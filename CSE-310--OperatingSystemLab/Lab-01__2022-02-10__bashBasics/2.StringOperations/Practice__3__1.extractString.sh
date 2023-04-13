#! /bin/bash
#* extract substring from 'string'

#* for remainder, index starts from 0 in programming most cases

string="This is a simple string!"

cuttingIndex=1
substringLength=3
echo ${string:$cuttingIndex:$substringLength}   # his
