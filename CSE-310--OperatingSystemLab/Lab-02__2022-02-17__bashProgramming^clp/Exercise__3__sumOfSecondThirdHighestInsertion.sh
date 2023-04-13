#! /bin/bash
#* second highest number from series of numbers without array

read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]
done

for (( i=1; i<length; i++ )); do
    temp=${numbers[$i]}
    j=$(($i-1))
    while [[ $j -ge 0 && ${numbers[$j]} -lt $temp ]]; do
        numbers[$(($j+1))]=$(( ${numbers[$(($j+1))]} + ${numbers[$j]} ))
        numbers[$j]=$(( ${numbers[$(($j+1))]} - ${numbers[$j]} ))
        numbers[$(($j+1))]=$(( ${numbers[$(($j+1))]} - ${numbers[$j]} ))
        ((j--))
    done
    numbers[$(($j+1))]=$temp
done


echo "Second Highest: ${numbers[1]} and Third Highest: ${numbers[2]}"
echo "Summation: ${numbers[1]} + ${numbers[2]} -> $(( ${numbers[1]} + ${numbers[2]} ))"
