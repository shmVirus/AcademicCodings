#! /bin/bash
#* replace occurrence of substring if it is at the end of string

#* '%' selects all characters, '%be' selects if be is available at end

string="to be or not to be"
echo ${string[@]/%be/eat}       # to be or not to eat
