#! /bin/bash
#* exploring while-loop syntax

n=1
while [ $n -le 5 ]; do  # continues till n <= 5
    echo "welcome $n times"
    n=$(( n+1 ))    # increments $n
done
