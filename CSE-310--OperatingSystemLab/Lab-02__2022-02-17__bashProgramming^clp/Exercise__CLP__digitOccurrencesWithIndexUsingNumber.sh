#! /bin/bash
#* print number of digit occurrences

read -p "Number: " number
number=${number#-}; number=`echo $number | rev` # stripping negative and reversing
declare -a digits
declare -a occurrences
declare -A indexes
echo $number
counter=-1
for ((index=0; $number > 0;  index++)); do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    isOccurred=0
    echo d:$digit n:$number
    for ((i=0 ; i<=$counter; i++)); do
        if [[ $digit -eq ${digits[$i]} ]]; then
            isOccurred=1
            length=${occurrences[$i]}
            #length=${#indexes[$i,@]}
            indexes[$i,$length]=$index
            (( occurrences[$i]++ ))
            break
        fi
    done
    if [[ $isOccurred -eq 0 ]]; then
        digits[$((++counter))]=$digit
        occurrences[$counter]=1
        indexes[$counter,0]=$index
    fi
done

counter=0
until [[ $counter -eq ${#digits[@]} ]]; do
    length=${occurrences[$counter]}
    if [[ $length -eq 1 ]]; then
	    echo -e "@${digits[$counter]}: ${occurrences[$counter]} time! @index: ${indexes[$counter,0]}"
    else
        echo -ne "@${digits[$counter]}: ${occurrences[$counter]} times! @indexes:"
        for ((j=0; j<length; j++)); do
            if [[ $(($j+1)) -eq $length ]]; then
                echo -e ' '${indexes[$counter,$j]}
            elif [[ $(($j+2)) -eq $length ]]; then
                echo -ne ' '${indexes[$counter,$j]}' and'
            else
                echo -ne ' '${indexes[$counter,$j]}','
            fi
        done
    fi
    ((counter++))
done
