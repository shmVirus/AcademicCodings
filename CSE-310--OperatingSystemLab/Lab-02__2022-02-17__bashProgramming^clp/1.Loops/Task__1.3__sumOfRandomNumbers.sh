#! /bin/bash
#* summation numbers divisible by 3 but not by 5; without array

for i in {50..100}; do
    if [[ $(($i%3)) -eq 0 && $(($i%5)) -gt 0 ]]; then
        sum=$(($sum+$i))
    fi
done
echo "Sum: $sum"
