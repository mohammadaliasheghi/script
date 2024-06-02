#!/usr/bin/env bash
# shellcheck disable=SC2164
cd ~/workspace/backend/framework/
mvn clean install compile -DskipTests=true
#after create file and add text run this command
sudo chmod 755 build.sh