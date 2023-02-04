#! /bin/bash
#* finds largest number among three numbers


read -p "First Number: " first
read -p "Second Number: " second
read -p "Third Number: " third

if [[ $first -ge $second && $first -ge $third ]]; then
    echo "Largest: $first among $first, $second and $third"
elif [[ $second -ge $first && $second -ge $third ]]; then
    echo "Largest: $second among $first, $second and $third"
elif [[ $third -ge $second && $third -ge $first ]]; then
    echo "Largest: $third among $first, $second and $third"
fi
