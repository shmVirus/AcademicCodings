#! /bin/bash
#* perimeter of circle, rectangle and triangle

read -p "Circle Radius: " radius
PI=3.1416
circle=`echo "scale=2; 2*$PI*$radius" | bc`


read -p "Rectangle Length: " length
read -p "Rectangle Width: " width
rectangle=$(echo "scale=2; 2*($length+$width)" | bc)


read -p "Triangle Length#1: " a
read -p "Triangle Length#2: " b
read -p "Triangle Length#3: " c
triangle=`echo "scale=2;($a+$b+$c)" | bc`


echo Circle: $circle, Rectangle: $rectangle and Triangle: $triangle
