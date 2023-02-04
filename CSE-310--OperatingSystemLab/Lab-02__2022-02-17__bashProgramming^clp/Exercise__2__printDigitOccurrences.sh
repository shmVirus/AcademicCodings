#! /bin/bash
#* print number of digit occurrences

read -p "Number: " number
number=${number#-}; number=`echo $number | rev`
declare -a digits
declare -a occurrences
counter=-1

while [[ $number -gt 0 ]]; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    isOccurred=0
    for ((i=0 ; i<=$counter; i++)); do
        if [[ $digit -eq ${digits[$i]} ]]; then
            (( occurrences[$i]++ ))
            isOccurred=1
            break
        fi
    done
    if [[ $isOccurred -eq 0 ]]; then
        digits[$((++counter))]=$digit
        occurrences[$counter]=1
    fi
done

counter=0
until [[ $counter -eq ${#digits[@]} ]]; do
    echo "@${digits[$counter]}: ${occurrences[$((counter++))]} times!"
done
