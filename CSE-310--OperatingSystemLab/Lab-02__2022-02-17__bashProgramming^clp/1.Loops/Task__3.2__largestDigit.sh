#! /bin/bash
#* largest digit from a number

read -p "Number: " number
number=${number#-}
largestDigit=$(( $number % 10 ))
number=$(( $number / 10 ))
until [ $number -le 0 ] ; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    if [[ $largestDigit -lt $digit ]]; then
      largestDigit=$digit
    fi
done
echo "Largest Digit: $largestDigit"
