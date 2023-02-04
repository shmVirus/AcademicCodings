#! /bin/bash
#* find sum of 'n' parameters

findSummation() {
    for i in $*; do
        sum=$(( $sum + $i ))
    done
    echo $sum
}
echo Summation: `findSummation $*`
