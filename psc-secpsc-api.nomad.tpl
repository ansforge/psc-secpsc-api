job "psc-secpsc-api" {
  datacenters = [
    "${datacenter}"]
  type = "service"
  namespace = "${nomad_namespace}"
  
  vault {
    policies = [
      "psc-ecosystem"]
    change_mode = "restart"
  }

  affinity {
    attribute = "$\u007Bnode.class\u007D"
    value = "standard"
  }

  group "psc-secpsc-api" {
    count = "1"
    restart {
      attempts = 3
      delay = "60s"
      interval = "1h"
      mode = "fail"
    }

    network {
      port "http" {
        to = 8080
      }
      port "filebeat" {
        to = 5066
      }
      port "exporter" {
        to = 8088
      }
    }

    scaling {
      enabled = true
      min = 1
      max = 5

      policy {
        cooldown = "180s"
        check "few_requests" {
          source = "prometheus"
          query = "min(max(http_server_requests_seconds_max{_app='psc-secpsc-api'}!= 0)by(instance))"
          strategy "threshold" {
            upper_bound = 2
            delta = -1
          }
        }

        check "many_requests" {
          source = "prometheus"
          query = "min(max(http_server_requests_seconds_max{_app='psc-secpsc-api'}!= 0)by(instance))"
          strategy "threshold" {
            lower_bound = 0.5
            delta = 1
          }
        }
      }
    }

    task "psc-secpsc-api" {
      driver = "docker"
      config {
        image = "${artifact.image}:${artifact.tag}"
        ports = [
          "http"]
      }

      template {
        destination = "local/file.env"
        env = true
        data = <<EOH
PUBLIC_HOSTNAME={{ with secret "psc-ecosystem/${nomad_namespace}/psc-secpsc-api" }}{{ .Data.data.public_hostname }}{{ end }}
JAVA_TOOL_OPTIONS="-Xms256m -Xmx2g -XX:+UseG1GC -Dspring.config.location=/secrets/application.properties"
EOH
      }

      template {
        data = <<EOF
spring.application.name=psc-secpsc-api
server.servlet.context-path=/psc-secpsc-api
openapi.pscApiMajV2.base-path=http://{{ range service "${nomad_namespace}-psc-api-maj-v2" }}{{ .Address }}:{{ .Port }}{{ end }}/psc-api-maj/api
logging.level.org.springframework.data.mongodb.core.MongoTemplate=INFO
spring.data.mongodb.host={{ range service "${nomad_namespace}-psc-mongodb" }}{{ .Address }}{{ end }}
spring.data.mongodb.port={{ range service "${nomad_namespace}-psc-mongodb" }}{{ .Port }}{{ end }}
spring.data.mongodb.database=mongodb
{{ with secret "psc-ecosystem/${nomad_namespace}/mongodb" }}spring.data.mongodb.username={{ .Data.data.root_user }} {{ end }}
EOF
        destination = "secrets/application.properties"
        change_mode = "restart"
      }

      resources {
        cpu = 500
        memory = 2560
      }
      service {
        name = "$\u007BNOMAD_NAMESPACE\u007D-$\u007BNOMAD_JOB_NAME\u007D"
        tags = ["urlprefix-sec-psc.api.preprod.esante.gouv.fr/psc-secpsc-api/api/ proto=http"]
        port = "http"
        check {
          type = "tcp"
          port = "http"
          interval = "30s"
          timeout = "2s"
          failures_before_critical = 5
        }
      }
    }
  }
}