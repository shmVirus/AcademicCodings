#! /bin/bash
#* replace first occurrence of substring

#* variable[@] variable[*] variable; all are similar, select whole string 
#* 1st '/' finds first occurrence, 2nd '/' replaces selected occurrence

string="to be or not to be"
echo ${string/be/eat}           # to eat or not to be
echo ${string[@]/be/eat}        # to eat or not to be
echo ${string[*]/be/eat}        # to eat or not to be
