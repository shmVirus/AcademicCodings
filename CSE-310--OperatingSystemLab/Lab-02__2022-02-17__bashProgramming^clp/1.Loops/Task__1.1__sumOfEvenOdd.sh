#! /bin/bash
#* summation of even numbers and odd numbers without array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read x
    if [[ $(($x % 2)) -eq 0 ]]; then
      evenSum=$(($evenSum+$x))
    else
      oddSum=$(($oddSum+$x))
    fi
done
echo "EvenSum: $evenSum and OddSum: $oddSum"
