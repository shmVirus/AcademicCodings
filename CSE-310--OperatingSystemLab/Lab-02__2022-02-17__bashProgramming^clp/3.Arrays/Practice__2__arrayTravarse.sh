#! /bin/bash
#* traversing array using while−loop

array=(1 12 31 4 5)
i=0
# loop upto size of array, starting from index i=0
while [ $i -lt ${#array[@]} ]; do
    echo ${array[$i]}   # prints i-th element
    i=`expr $i + 1`     # increments i, i++
done
