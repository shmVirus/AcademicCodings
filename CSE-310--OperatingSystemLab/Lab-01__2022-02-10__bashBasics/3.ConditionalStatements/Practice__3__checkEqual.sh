#! /bin/bash
#* checking two numbers if equal or not

a=$1
b=$2
if [ $a == $b ]; then
    echo "$a is equal to $b"
else
    echo "$a is not equal to $b"
fi
