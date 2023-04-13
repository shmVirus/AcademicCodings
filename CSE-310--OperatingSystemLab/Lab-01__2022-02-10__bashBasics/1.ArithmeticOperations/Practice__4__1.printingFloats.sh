#! /bin/bash
#* floating−point arithmetic operations

#* bc command is used for command line calculator
#* similar to expr command, both evaluates arithmetic expressions
#* bc supports arithmetic, logical, mathematical functions etcetera

echo "scale = 5; 123.456789/345.345345" | bc    # .35748
echo "scale=4;20+5/2" | bc                      # 22.5000
echo "scale=2;25.7555" | bc # scale not worked? because of no-operations!
