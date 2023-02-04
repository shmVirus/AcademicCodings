#! /bin/bash
#* exploring while-loop syntax

string=hello
while [ "$string" != "bye" ]; do
    echo "Your Input? (bye to quit)"
    read string
    echo "You Typed: $string"
done
