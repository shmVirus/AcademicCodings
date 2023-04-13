#! /bin/bash
#* armstrong number

read -p "Number: " number
#number=${number#-}
length=${#number}
temp=$number
sum=0
while [ "$number" != "0" ] ; do
    digit=$(( $number % 10 ))
    number=$(( $number / 10 ))
    sum=$(( $sum + $digit**$(($length)) ))
done
echo -n "Status: "
if [[ $sum -eq $temp ]]; then
    echo "Armstrong!"
else
  echo "Not Armstrong!"
fi
