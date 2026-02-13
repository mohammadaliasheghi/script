myArray+=(a b c d e f)
#for loop
for (( i = 0; i < "${#myArray[@]}"; i++ )); do
echo "${myArray[$i]}"
done
