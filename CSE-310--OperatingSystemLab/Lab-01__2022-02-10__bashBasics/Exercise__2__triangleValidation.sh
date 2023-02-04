#! /bin/bash
#* triangle vaildation

#* swapped largest value to third vaiable for one formula

read -p "Length #1: " first
read -p "Length #2: " second
read -p "Length #3: " third

# not required first+second>third can handle this, though nice to have
#if [[ $first -le 0 || $second -le 0 || $third -le 0 ]]; then
#    echo "Status: InValid Triangle! Length's can't be 0"
#    exit
#fi

if [[ $first -ge $second && $first -ge $third ]]; then
    first=`echo "scale=2; $first+$third" | bc`
    third=`echo "scale=2; $first-$third" | bc`
    first=`echo "scale=2; $first-$third" | bc`
elif [[ $second -ge $first && $second -ge $third ]]; then
    second=`echo "scale=2; $second+$third" | bc`
    third=`echo "scale=2; $second-$third" | bc`
    second=`echo "scale=2; $second-$third" | bc`
fi

if [[ $first+$second -gt $third ]]; then
    echo "Status: Valid Triangle!"
else
    echo "Status: InValid Triangle!"
fi
