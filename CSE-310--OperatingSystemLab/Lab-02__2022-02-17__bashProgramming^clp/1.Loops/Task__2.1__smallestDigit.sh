#! /bin/bash
#* smallest digit from a number

read -p "Number: " number
number=${number#-}
smallestDigit=$(( $number % 10 ))
number=$(( $number / 10 ))
while [ $number -gt 0 ] ; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    if [[ $smallestDigit -gt $digit ]]; then
      smallestDigit=$digit
    fi
done
echo "Smallest Digit: $smallestDigit"
