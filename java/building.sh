#!/usr/bin/env bash
#clean install compile java spring boot application
cic(){
  local path=${1:?err! no parameter!}
  # shellcheck disable=SC2164
  cd "$path"
  mvn clean install compile -DskipTests=true
}
cic ~/workspace/backend/framework/
cic ~/workspace/backend/cloud-platform/eureka-server/
cic ~/workspace/backend/cloud-platform/common-lib/
cic ~/workspace/backend/cloud-platform/log-lib/
cic ~/workspace/backend/cloud-platform/security-lib/
cic ~/workspace/backend/cloud-platform/cache-service/
cic ~/workspace/backend/cloud-platform/oauth-server/
cic ~/workspace/backend/cloud-platform/user-service/
cic ~/workspace/backend/cloud-platform/gateway/
cic ~/workspace/backend/generalServiceBackend/