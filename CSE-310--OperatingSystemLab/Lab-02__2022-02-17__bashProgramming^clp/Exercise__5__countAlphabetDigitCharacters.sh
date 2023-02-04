#! /bin/bash
#* count alphabets, digits and special characters 

read -p "String: " string
alphabets=0; digits=0; specialCharacters=0
for ((i=0; i<${#string}; i++)); do
    if [[ ${string:$i:1} =~ [A-Za-z] ]]; then
        (( alphabets++ ))
    elif [[ ${string:$i:1} =~ [0-9] ]]; then
        (( digits++  ))
    else
        (( specialCharacters++ ))
    fi
done
echo -e "Digits: $digits\nAlhpabets: $alphabets\nSpecial Characters: $specialCharacters"
