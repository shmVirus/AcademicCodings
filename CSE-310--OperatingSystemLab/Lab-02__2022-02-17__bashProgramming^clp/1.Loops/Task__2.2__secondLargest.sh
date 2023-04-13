#! /bin/bash
#* second largest digit from a number

read -p "Number: " number
if [[ ${#number} -lt 2 ]]; then
    echo "Invalid Number, length should be > 1!"
    exit
fi

number=${number#-}
largestDigit=$(( $number % 10 ))
secondLargest=$(( $(($number % 100))/10 ))

if [[ $secondLargest -gt $largestDigit ]]; then
    largestDigit=$(( $largestDigit + $secondLargest ))
    secondLargest=$(( $largestDigit - $secondLargest ))
    largestDigit=$(( $largestDigit - $secondLargest ))
fi

while [ $number -gt 0 ]; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    if [[ $digit -gt $largestDigit ]]; then
        secondLargest=$largestDigit
        largestDigit=$digit
    elif [[ $digit -gt $secondLargest && $digit -lt $largestDigit ]]; then
        secondLargest=$digit
    fi
done
echo "Second Largest Digit: $secondLargest"
