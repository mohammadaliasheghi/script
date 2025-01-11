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

  if [ -d "$jar_path" ]; then
    green_bg=`tput setab 2`
    reset=`tput sgr0`
    echo "${green_bg}running $app_name${reset}"
    cd "$jar_path"
    if [ -e app.jar ]; then
        echo "exists $app_name"
        else
          mv *.jar app.jar
    fi
    java -jar app.jar &
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

ejs eureka-server ~/workspace/backend/cloud-platform/eureka-server/target/
ejs cache-service ~/workspace/backend/cloud-platform/cache-service/target/
ejs oauth-server ~/workspace/backend/cloud-platform/oauth-server/target/
ejs user-service ~/workspace/backend/cloud-platform/user-service/target/
ejs gateway ~/workspace/backend/cloud-platform/gateway/target/
ejs general-service ~/workspace/backend/generalServiceBackend/target/
echo "all server is up."
