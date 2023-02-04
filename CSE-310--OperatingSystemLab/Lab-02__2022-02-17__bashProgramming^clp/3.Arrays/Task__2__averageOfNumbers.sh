#! /bin/bash
#* average of n numbers


read -p "Length of Numbers: " length
declare -a numbers

for (( i=0; i<length; i++ )); do
    read numbers[$i]
    sum=$(( $sum+${numbers[$i]} ))
done

average=`echo "scale=2; $sum/$length" | bc`

echo "Average: $average"
