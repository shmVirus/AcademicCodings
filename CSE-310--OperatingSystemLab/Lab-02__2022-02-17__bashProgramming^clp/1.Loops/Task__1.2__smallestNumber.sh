#! /bin/bash
#* smallest number from series of numbers without array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read x
    if [[ $i -eq 0 ]]; then
      smallest=$x
    else
        if [[ $x -le $smallest ]]; then
            smallest=$x
        fi
    fi
done
echo "Smallest: $smallest"
