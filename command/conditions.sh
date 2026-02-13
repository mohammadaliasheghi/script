echo please enter number one!
read -r var1
echo please enter number two!
read -r var2
#conditions
if [[ $var1 > $var2 ]]; then
	echo "$var1" ">" "$var2"
elif [[ $var2 > $var1 ]]; then
	echo "$var2" ">" "$var1"
else
	echo "$var2" "=" "$var1"
fi
#conditions
echo "please enter yes to continue!"
read -r string
if [[ $string != "yes" && $string != "no" ]]; then
    echo "please enter yes or no!"
    else
      echo "ok"
fi