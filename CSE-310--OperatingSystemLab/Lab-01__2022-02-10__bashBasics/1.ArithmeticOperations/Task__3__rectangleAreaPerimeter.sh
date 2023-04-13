#! /bin/bash
#* area and perimeter of rectangle

read -p "Rectangle Length: " length
read -p "Rectangle Width: " width

area=$(echo "scale=2; $length*$width" | bc)
perimeter=$(echo "scale=2; 2*($length+$width)" | bc)

echo Area: $area and Perimeter: $perimeter
