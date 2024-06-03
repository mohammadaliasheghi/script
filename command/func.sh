welcome() {
	local name=${1:?err! no parameter!}
	echo "Hello ${name}"
}
welcome sir

fun(){
	local var=cin!
	echo $var
}
temp=$(fun)
echo "$temp"