#! /bin/bash
#* factorial of a number

read -p "Number: " number
factorial=1
echo -n "Factorial: "
if [[ $number -lt 0 ]]; then
    number=${number#-}
    echo -n "-"
fi

for (( number; number>0; number-- )); do
    factorial=$(($factorial*$number))
done
echo "$factorial"
