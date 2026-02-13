name="name"
echo "${name^}"
#output -> Name
echo "${name^^}"
#output -> NAME
temp="${name^^}"
echo "${temp,}"
#output -> nAME
echo "${temp,,}"
#output -> name