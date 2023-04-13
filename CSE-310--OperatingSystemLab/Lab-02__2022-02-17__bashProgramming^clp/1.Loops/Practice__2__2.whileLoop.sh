#! /bin/bash
#* exploring while-loop syntax

n=1
while (( $n <= 5 )); do
    echo "welcome $n times"
    n=$(( n+1 ))
done
