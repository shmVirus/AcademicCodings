#! /bin/bash
#* sum of digits

read -p "Number: " number
number=${number#-}

while [[ ${#number} -gt 0 && $number -gt 0 ]]; do

    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    sum=$(( $sum + $digit ))
  
done

echo "Summation: $sum"
