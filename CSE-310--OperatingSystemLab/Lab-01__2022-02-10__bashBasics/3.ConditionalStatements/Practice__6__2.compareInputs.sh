#! /bin/bash
#* string comparison after taking from console

read -p "First String: " stringOne
read -p "Second String: " stringTwo
if [[ "$stringOne" == "$stringTwo" ]]; then
    echo "Strings are Equal!"
else
    echo "Strings are not Equal!"
fi
