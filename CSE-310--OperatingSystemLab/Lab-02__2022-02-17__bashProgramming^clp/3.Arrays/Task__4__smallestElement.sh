#! /bin/bash
#* smallest number from series of numbers using array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]

    if [[ $i -eq 0 ]]; then
        smallest=${numbers[$i]}

    else
        if [[ ${numbers[$i]} -le $smallest ]]; then
            smallest=${numbers[$i]}
        fi
    fi
done

echo "Smallest: $smallest"
