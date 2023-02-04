#! /bin/bash
#* basic if statement

#* '-gt' used for number comparison as '>' compares both number and string

if [ $1 -gt 100 ]; then 
    echo Hey that\'s a large number
elif [ $1 -lt 100 ]; then
    echo Hey that\'s a small number
fi
