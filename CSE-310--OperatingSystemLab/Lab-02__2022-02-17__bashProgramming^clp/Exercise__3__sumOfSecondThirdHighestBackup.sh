#! /bin/bash
#* second highest number from series of numbers without array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]
    if [[ $i -eq 0 ]]; then
        highest=${numbers[$i]}
        secondHighest=$highest
        thirdHighest=$secondHighest
    elif [[ $i -eq 1 || $i -eq 2 && ${numbers[$i]} -lt $thirdHighest ]]; then
        secondHighest=$thirdHighest
        thirdHighest=${numbers[i]}
    elif [[ $i -eq 2 ]]; then
        if [[ ${numbers[$i]} -lt $secondHighest && ${numbers[$i]} -gt $thirdHighest ]]; then
            secondHighest=${numbers[$i]}
        fi
    else
        if [[ ${numbers[$i]} -gt $highest ]]; then
            thirdHighest=$secondHighest
            secondHighest=$highest
            highest=${numbers[$i]}
        elif [[ ${numbers[$i]} -gt $secondHighest && ${numbers[$i]} -gt $thirdHighest && ${numbers[$i]} -lt $highest ]]; then
            thirdHighest=$secondHighest
            secondHighest=${numbers[$i]}
        elif [[ ${numbers[$i]} -gt $thirdHighest && ${numbers[$i]} -lt $secondHighest ]]; then
            thirdHighest=${numbers[$i]}
        fi
    fi
done

echo "Second Highest: $secondHighest and Third Highest: $thirdHighest"
echo "Summation: $secondHighest + $thirdHighest -> $(($secondHighest+$thirdHighest))"
