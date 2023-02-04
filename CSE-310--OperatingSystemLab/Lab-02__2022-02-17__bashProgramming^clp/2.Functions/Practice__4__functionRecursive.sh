#! /bin/bash
#* calculating factorial using recursive function; has bugs, read code

findFactorial() {
    factorial=1
    if [ "$1" != "1" ]; then # why doesn't work with '-gt', '>?
        i=`expr $1 - 1`
        j=`findFactorial $i`
        factorial=`expr $1 \* $j` 
        echo $factorial

        #factorial=factorial\*$1
        #i=$1−1
        #findFactorial $i
    else        # [[ $1 == 1 || $1 == 0 ]]; then; still error when 0?
        echo $factorial
    fi
}
read -p "Number: " number
echo "Factorial: `findFactorial $number`"
