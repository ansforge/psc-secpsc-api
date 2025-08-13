job "psc-psi-api" {
  datacenters = ["${datacenter}"]
  namespace = "${nomad_namespace}"
  
  group "psc-psi-api" {
    count = 1

    network {
      port "http" {
        to = 8080
      }
    }

    service {
      name = "psc-psi-api"
      port = "http"
      
      tags = [
        "urlprefix-/psc-psi-api"
      ]

      check {
        type     = "http"
        path     = "/psc-psi-api/actuator/health"
        interval = "10s"
        timeout  = "2s"
      }
    }

    task "server" {
      driver = "docker"

      config {
        image = "${artifact.image}:${artifact.tag}"
        ports = ["http"]
      }

      resources {
        cpu    = 500
        memory = 512
      }

      env {
        SPRING_PROFILES_ACTIVE = "prod"
      }
    }
  }
}
