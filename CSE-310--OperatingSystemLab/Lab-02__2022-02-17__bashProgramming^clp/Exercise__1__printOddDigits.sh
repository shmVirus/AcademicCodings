#! /bin/bash
#* print odd digits from a number using for loop

read -p "Number: " number

for ((i=0; i<${#number}; i++)); do
    if [[ $(( ${number:$i:1} % 2 )) -gt 0 ]]; then
        echo "@index $i: ${number:$i:1}"
    fi
done
