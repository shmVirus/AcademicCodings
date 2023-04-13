#! /bin/bash
#* replace all occurrences of substring

#* '//' selects all occurrences

string="to be or not to be"
echo ${string[@]//be/eat}       # to eat or not to eat
