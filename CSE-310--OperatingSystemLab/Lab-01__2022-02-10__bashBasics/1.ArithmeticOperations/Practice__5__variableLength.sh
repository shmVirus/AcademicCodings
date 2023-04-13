#! /bin/bash
#* show the length of a variable

#* ${#variableName} this works like as length operator
#* without '$' prints echo's argument | without '#' prints value

a='Hello World'
echo ${#a}      # 11
b=4953
echo ${#b}      # 4
