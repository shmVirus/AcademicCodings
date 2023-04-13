#! /bin/bash
#* largest number from series of numbers using array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]

    if [[ $i -eq 0 ]]; then
        largest=${numbers[$i]}
    
    else
        if [[ ${numbers[$i]} -gt $largest ]]; then
            largest=${numbers[$i]}
        fi
    fi
done

echo "Largest: $largest"
