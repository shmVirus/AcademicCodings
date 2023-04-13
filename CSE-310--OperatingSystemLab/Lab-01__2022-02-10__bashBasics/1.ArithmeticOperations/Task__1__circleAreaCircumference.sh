#! /bin/bash
#* area and circumference of cirle

#* to assign value from expr we must use ``/$(); for multiplication '\*'
#* $(()) expansion doesn't need things like expr, for multiplication '*'
#* in scope, its better to use $() instead of ``

read -p "Circle Radius: " radius
PI=3.1416


area=$(echo "scale=2; $PI*$radius^2" | bc)
circumference=`echo "scale=2; 2*$PI*$radius" | bc`

echo -ne "\033[36;1mArea: \033[0m"
echo -ne "\033[5m$area\033[0m\n"
echo -ne "\033[36;1mCircumference: \033[0m"
echo -ne "\033[5m$circumference\033[0m\n"



#! following lines also do multiplication, but only for intergers
#area1=`expr $PI \* $radius \* $radius`
#area2=$(expr $PI \* $radius \* $radius)
#area3=$(( $PI * $radius * $radius ))
#let area4="$PI*$radius*$radius"
