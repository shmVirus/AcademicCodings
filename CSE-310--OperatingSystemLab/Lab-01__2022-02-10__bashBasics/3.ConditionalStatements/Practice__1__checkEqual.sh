#! /bin/bash
#* checking two numbers if equal or not

# initializing two variables
a=$1
b=$2

# check whether they are equal
if [ $a == $b ]
    then echo "$a is equal to $b"   # then keyword default syntax
fi
# check whether they are not equal
if [ $a != $b ]; then   # to use then next to if, ';' needs to placed
    echo "$a is not equal to $b"
fi
