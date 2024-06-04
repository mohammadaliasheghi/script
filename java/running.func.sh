#!/usr/bin/env bash
#add stop file
stop_file=~/Documents/.stop.sh
if [ -f $stop_file ]; then
    echo "#stop servers" > $stop_file
    else
      touch ~/Documents/.stop.sh
      sudo chmod 755 ~/Documents/.stop.sh
fi
#execution java spring boot application
ejs(){
  local app_name=${1:?err! no parameter!}
  local jar_path=${2:?err! no parameter!}
  local jar_file=${3:?err! no parameter!}

  if [ -d "$jar_path" ]; then
      echo "running $app_name"
      # shellcheck disable=SC2164
      cd "$jar_path"
      java -jar "$jar_file" &
      process_id=$!
      echo $process_id
      echo "#$app_name" >> $stop_file
      echo "kill $process_id" >> $stop_file
      sleep 15
      else
        echo "$app_name not fund!"
        sleep 10
        exit
  fi
}

ejs eureka-server ~/workspace/backend/cloud-platform/eureka-server/target/ eureka-server-1.0.0.jar
ejs cache-service ~/workspace/backend/cloud-platform/cache-service/target/ cache-service-1.0.0.jar
ejs oauth-server ~/workspace/backend/cloud-platform/oauth-server/target/ oauth-server-0.0.1-SNAPSHOT.jar
ejs user-service ~/workspace/backend/cloud-platform/user-service/target/ user-service-0.0.1-SNAPSHOT.jar
ejs gateway ~/workspace/backend/cloud-platform/gateway/target/ gateway-1.0.0.jar
ejs general-service ~/workspace/backend/generalServiceBackend/target/ general-service-0.0.1-SNAPSHOT.jar
echo "all server is up."