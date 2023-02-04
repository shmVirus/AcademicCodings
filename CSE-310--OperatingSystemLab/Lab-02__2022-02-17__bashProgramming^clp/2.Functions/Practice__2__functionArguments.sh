#! /bin/bash
#* pass parameters to a function

printHello () {
    echo "$1 $2!"
}
read -p "Name: " name
printHello Hello $name    # without '$' sign, means string
