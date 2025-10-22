project = "${workspace.name}/psc-secpsc-api"

# Labels can be specified for organizational purposes.
labels = {
  "domaine" = "psc"
}

runner {
  enabled = true
  profile = "secpsc-${workspace.name}"
  data_source "git" {
    url = "https://github.com/ansforge/psc-secpsc-api.git"
    ref = "${workspace.name}"
  }
  poll {
    enabled = false
  }
}

# An application to deploy.
app "prosanteconnect/psc-secpsc-api" {
  build {
    use "docker" {
      build_args = {"PROSANTECONNECT_PACKAGE_GITHUB_TOKEN"="${var.github_token}"}
      dockerfile = "${path.app}/${var.dockerfile_path}"
      disable_entrypoint = true
    }
    registry {
      use "docker" {
        image = "${var.registry_username}/psc-secpsc-api"
        tag = gitrefpretty()
        username = var.registry_username
        password = var.registry_password
        local = true
      }
    }
  }

  # Deploy to Nomad
  deploy {
    use "nomad-jobspec" {
      jobspec = templatefile("${path.app}/psc-secpsc-api.nomad.tpl", {
        datacenter = var.datacenter
        nomad_namespace = var.nomad_namespace
      })
    }
  }
}

variable "datacenter" {
  type = string
  default = ""
  env = ["NOMAD_DATACENTER"]
}

variable "nomad_namespace" {
  type = string
  default = ""
  env = ["NOMAD_NAMESPACE"]
}

variable "registry_username" {
  type    = string
  default = ""
  env     = ["REGISTRY_USERNAME"]
  sensitive = true
}

variable "registry_password" {
  type    = string
  default = ""
  env     = ["REGISTRY_PASSWORD"]
  sensitive = true
}

variable "proxy_address" {
  type = string
  default = ""
}

variable "dockerfile_path" {
  type = string
  default = "Dockerfile"
}

variable "github_token" {
  type = string
  default = ""
  env = ["PROSANTECONNECT_PACKAGE_GITHUB_TOKEN"]
  sensitive = true
}
