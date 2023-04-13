#! /bin/bash
#* sum of two factorials

findFactorial() {
    number=$1
    factorial=1
    if [[ $number -lt 0 ]]; then
        number=${number#-}
    fi

    for (( number; number>0; number-- )); do
        factorial=$(($factorial*$number))
    done

    echo "$factorial" 
}

read -p "First Number: " first
read -p "Second Number: " second
echo -n "Summation: $first! + $second! -> "

if [[ $first -ge 0 && $second -ge 0 ]]; then
    echo "`findFactorial $first` + `findFactorial $second` -> $(( `findFactorial $first` + `findFactorial $second` ))"
elif [[ $first -lt 0 && $second -lt 0 ]]; then
    echo "- `findFactorial $first` - `findFactorial $second` -> $(( -`findFactorial $first` - `findFactorial $second` ))"
elif [[ $first -ge 0 && $second -lt 0 ]]; then
    echo "`findFactorial $first` - `findFactorial $second` -> $(( `findFactorial $first` - `findFactorial $second` ))"
elif [[ $first -lt 0 && $second -ge 0 ]]; then
    echo "- `findFactorial $first` + `findFactorial $second` -> $(( -`findFactorial $first` + `findFactorial $second` ))"
fi
