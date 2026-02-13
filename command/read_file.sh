#!/usr/bin/env bash
# shellcheck disable=SC1007
my_array=()
while input_file_stream= read -r line ; do
    my_array+=("$line")
done < ~/workspace/dev/github/script/docker/postgres.sh

for i in "${my_array[@]}"; do
  echo "$i"
done