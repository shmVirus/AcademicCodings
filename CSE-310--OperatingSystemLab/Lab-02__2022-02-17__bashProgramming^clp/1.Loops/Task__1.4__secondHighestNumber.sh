#! /bin/bash
#* second highest number from series of numbers without array

read -p "Length of Numbers: " length

for (( i=0; i<length; i++ )); do
    read x
    if [[ $i -eq 0 ]]; then
        highest=$x
        secondHighest=$x

    elif [[ $i -eq 1 && $x -lt $secondHighest ]]; then
        secondHighest=$x

    else
        if [[ $x -gt $highest ]]; then
            secondHighest=$highest
            highest=$x
        elif [[ $x -gt $secondHighest && $x -lt $highest ]]; then
            secondHighest=$x
        fi
    fi
done

echo "Second Highest: $secondHighest"
