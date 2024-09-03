#download kafka with docker from github
https://github.com/conduktor/kafka-stack-docker-compose
#start kafka with docker compose
sudo docker-compose -f zk-single-kafka-single.yml up -d
#must be check up (kafka1, zoo1) & docker exec command
sudo docker exec -it kafka1 /bin/bash
#down kafka server
sudo docker-compose -f zk-single-kafka-single.yml down