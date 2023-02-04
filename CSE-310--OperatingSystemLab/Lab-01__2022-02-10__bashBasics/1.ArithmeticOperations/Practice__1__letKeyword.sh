#! /bin/bash
#* basic arithmetic operations using 'let'

#* let command evaluates arithmetic expressions on shell variables
#* echo command prints arguments (text or variable) passed to echo

let a=5+4       # space separates commands, so no space
echo $a         # 9

let "a = 5 + 4" # to use space, quotation used
echo $a         # 9

let a++         # for increment/decrement we need to use let keyword
echo $a         # 10

let "a = 4 * 5"
echo $a         # 20

let a=$1+30     # '$#' arguments from console, # means i-th argument & i>0
echo $a         # $a=valueOfArgument+30
