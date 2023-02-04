#! /bin/bash
#* sum of even and odd digits

read -p "Number: " number
number=${number#-}
until [[ $number -eq 0 ]]; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    if [[ $(($digit%2)) -eq 0 ]]; then
        evenSum=$(( $evenSum + $digit ))
    else
        oddSum=$(( $oddSum + $digit ))
    fi  
done
echo "EvenSum: $evenSum and OddSum: $oddSum"
