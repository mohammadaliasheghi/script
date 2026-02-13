myArray+=(a b c d e f)
#while loop
i=0
while [[ "$i" -lt "${#myArray[@]}" ]]; do
    echo "${myArray[$i]}"
    ((i++))
done
