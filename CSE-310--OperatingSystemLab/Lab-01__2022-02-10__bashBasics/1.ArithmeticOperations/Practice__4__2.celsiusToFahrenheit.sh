#! /bin/bash
#* bash shell script to convert Celsius to Fahrenheit

#* read takes user input from stdin aka console
#* -p identifier prompts string to console, used here to print "Celsius: "
#* backquote `` grouping commands inside it, like as scoope

read -p "Celsius: " celsius     # holding float? no! holding string
fahrenheit=`echo "scale=2;$celsius*1.8+32" | bc`
echo "Fahrenheit: $fahrenheit"  # how to control float scale of fahrenheit?
