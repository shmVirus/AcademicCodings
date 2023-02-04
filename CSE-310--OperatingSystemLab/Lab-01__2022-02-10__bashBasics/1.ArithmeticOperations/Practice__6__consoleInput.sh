#! /bin/bash
#* takes input from user and calculates sum

#* nothing new here, used previous commands

read -p "First Number: " firstNumber
read -p "second Number: " secondNumber

summation=$(( $firstNumber + $secondNumber ))
echo "Sum of both Numbers: $summation"
