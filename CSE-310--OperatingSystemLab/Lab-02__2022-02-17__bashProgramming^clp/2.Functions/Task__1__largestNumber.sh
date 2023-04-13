#! /bin/bash
#* find largest using function

findLargest() {
    a=$1
    b=$2
    if [ $a == $b ]; then
        echo "$a is equal to $b"
    elif [ $a -gt $b ]; then
        echo "$a is greater than $b"
    elif [ $b -gt $a ]; then
        echo "$b is greater than $a"
    else
        echo "Invalid Comparison!"
    fi
}
read -p "First Number: " first
read -p "Second Number: " second
echo -n "Result: "
findLargest $first $second
