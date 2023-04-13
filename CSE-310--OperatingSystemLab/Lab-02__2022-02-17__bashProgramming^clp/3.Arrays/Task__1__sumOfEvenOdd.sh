#! /bin/bash
#* summation of even numbers and odd numbers using array

#* read array variable[index], access array ${variable[index]}


read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]

    if [[ $(( ${numbers[$i]} % 2 )) -eq 0 ]]; then
        evenSum=$(($evenSum+${numbers[$i]}))
    else
        oddSum=$(($oddSum+${numbers[$i]}))
    fi
done

echo "EvenSum: $evenSum and OddSum: $oddSum"
