#!/usr/bin/env bash
#script for download links with custom file name
d_links(){
  local path=${1:?err! no parameter!}
  local output_path=${2:?err! no parameter!}
  local base_file_name=${3:?err! no parameter!}
  local start_value=${4:?err! no parameter!}
links=()
while IFS= read -r line ; do
    links+=("$line")
done < "$path"

sv="${start_value}"
code=''
for i in "${links[@]}"; do
    if [[ $sv -lt 10 ]]; then
            code="00${sv}"
        elif [[ $sv -lt 100 ]]; then
            code="0${sv}"
        else
            code="${sv}"
    fi
  # shellcheck disable=SC2006
  link=`wget "${i}" -P "${output_path}" -O "${base_file_name}-${code}"`
        while [ "$link" -ne 0 ]; do
            sleep 10
        done
  ((sv++))
done
}

d_links ~/Downloads/react-test.txt ~/Downloads/react rjs 1