#! /bin/bash
#* extract string in different ways

#* while we don't provide substring length, it takes till end

greetings="Welcome to virusArena!"
echo ${greetings:11}    # virusArena!
echo ${greetings:11:5}  # virus

string="This is a string"
echo ${string:1}        # his is a string
echo ${string:12}       # ring
