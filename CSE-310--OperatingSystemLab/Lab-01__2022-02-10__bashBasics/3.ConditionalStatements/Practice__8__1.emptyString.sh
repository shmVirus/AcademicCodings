#! /bin/bash
#* check if the string is empty or not

#* −n and −z checks if the string is empty or not

emptyString=''
if [[ -z $emptyString ]]; then
    echo "String is Empty!"
fi
