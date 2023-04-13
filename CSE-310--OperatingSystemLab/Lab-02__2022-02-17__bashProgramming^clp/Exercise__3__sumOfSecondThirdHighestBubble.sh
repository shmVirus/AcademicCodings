#! /bin/bash
#* second highest number from series of numbers without array


read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]
done


for (( i=0; i<length; i++ )); do
    for (( j=0; j<length-1; j++ )); do
        if [[ ${numbers[$(($j+1))]} -gt ${numbers[$j]} ]]; then
            numbers[$(($j+1))]=$(( ${numbers[$(($j+1))]} + ${numbers[$j]} ))
            numbers[$j]=$(( ${numbers[$(($j+1))]} - ${numbers[$j]} ))
            numbers[$(($j+1))]=$(( ${numbers[$(($j+1))]} - ${numbers[$j]} ))
        fi
    done
done


echo "Second Highest: ${numbers[1]} and Third Highest: ${numbers[2]}"
echo "Summation: ${numbers[1]} + ${numbers[2]} -> $(( ${numbers[1]} + ${numbers[2]} ))"
