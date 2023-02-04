#! /bin/bash
#* replace occurrence of substring if at the beginning of string

#* '#' selects all characters, '#to' selects if to is available at start

string="to be or not to be"
echo ${string[@]/#to be/eat now}        #!# eat now or not to be
