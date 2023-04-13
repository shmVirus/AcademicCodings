#! /bin/bash
#* concatenates two strings

read -p "First String: " firstString
read -p "Second String: " secondString
concatenatedString=$firstString$secondString
echo Concatenated String: $concatenatedString
