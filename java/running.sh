#!/usr/bin/env bash
#add stop file
stop_file=~/Documents/.stop.sh
if [ -f $stop_file ]; then
    echo "#stop servers" > $stop_file
    else
      touch ~/Documents/.stop.sh
      sudo chmod 755 ~/Documents/.stop.sh
fi
#eureka-server
jar_path=~/workspace/backend/cloud-platform/eureka-server/target/
if [ -d $jar_path ]; then
    echo "running eureka-server"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar eureka-server-1.0.0.jar &
    eureka_process_id=$!
    echo $eureka_process_id
    echo "kill $eureka_process_id" >> $stop_file
    sleep 15
    else
      echo "eureka-server not fund!"
      sleep 10
      exit
fi
#cache-service
jar_path=~/workspace/backend/cloud-platform/cache-service/target/
if [ -d $jar_path ]; then
    echo "running cache-service"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar cache-service-1.0.0.jar &
    cache_process_id=$!
    echo $cache_process_id
    echo "kill $cache_process_id" >> $stop_file
    sleep 15
    else
      echo "cache-service not fund!"
      sleep 10
      exit
fi
#oauth-server
jar_path=~/workspace/backend/cloud-platform/oauth-server/target/
if [ -d $jar_path ]; then
    echo "running oauth-server"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar oauth-server-0.0.1-SNAPSHOT.jar &
    oauth_process_id=$!
    echo $oauth_process_id
    echo "kill $oauth_process_id" >> $stop_file
    sleep 15
    else
      echo "oauth-server not fund!"
      sleep 10
      exit
fi
#user-service
jar_path=~/workspace/backend/cloud-platform/user-service/target/
if [ -d $jar_path ]; then
    echo "running user-service"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar user-service-0.0.1-SNAPSHOT.jar &
    user_process_id=$!
    echo $user_process_id
    echo "kill $user_process_id" >> $stop_file
    sleep 15
    else
      echo "user-service not fund!"
      sleep 10
      exit
fi
#gateway
jar_path=~/workspace/backend/cloud-platform/gateway/target/
if [ -d $jar_path ]; then
    echo "running gateway"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar gateway-1.0.0.jar &
    gateway_process_id=$!
    echo $gateway_process_id
    echo "kill $gateway_process_id" >> $stop_file
    sleep 15
    else
      echo "gateway not fund!"
      sleep 10
      exit
fi
#general-service
jar_path=~/workspace/backend/generalServiceBackend/target/
if [ -d $jar_path ]; then
    echo "running general-service"
    # shellcheck disable=SC2164
    cd $jar_path
    java -jar general-service-0.0.1-SNAPSHOT.jar &
    general_process_id=$!
    echo $general_process_id
    echo "kill $general_process_id" >> $stop_file
    sleep 15
    else
      echo "general-service not fund!"
      sleep 10
      exit
fi
echo "all server is up."