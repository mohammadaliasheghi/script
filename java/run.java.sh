#!/usr/bin/env bash
#clean stop.sh file
echo "#stop servers" > ~/Documents/script/stop.sh
# execute servers
# shellcheck disable=SC2164
cd ~/workspace/backend/cloud-platform/eureka-server/target/
java -jar eureka-server-1.0.0.jar &
eureka_process_id=$!
echo $eureka_process_id
echo "kill $eureka_process_id" >> ~/Documents/script/stop.sh
sleep 15
#after create file and add text run this command
sudo chmod 755 run.sh