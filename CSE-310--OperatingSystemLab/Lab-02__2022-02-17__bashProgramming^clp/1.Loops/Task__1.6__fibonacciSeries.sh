#! /bin/bash
#* fibonacci series

read -p "Series till?: " till

a=0
b=1
echo -n "Fibonacci Series: "

for (( i=0; a<$till; i++)); do
    echo -n $a
    if [[ $(($a+$b)) -ge $till ]]; then
        echo
    else
        echo -n " "
    fi
    c=$a
    a=$(($a+$b))
    b=$c
done
