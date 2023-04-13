#! /bin/bash
#* find numeric position in $string that matches any character of $subString

#* 'expr index' command searches in first string for first occurrence of any character in second string

string="This is an another string!"
subString="Sweets"

# 4 is position of 's' from string that matches with subString
expr index "$string" "$subString"
