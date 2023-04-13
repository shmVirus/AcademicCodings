#! /bin/bash
#* basic function implementation

# function definition goes here
printHello () {
    read -p "Name: " name
    echo "Hello $name!"
}
# invoking the function
printHello
