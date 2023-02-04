#! /bin/bash
#* string comparison

stringOne="shmVirus"
stringTwo="shmVirus"
if [ "$stringOne" = "$stringTwo" ]; then
    echo "Strings are Equal!"
else
    echo "Strings are not Equal!"
fi
