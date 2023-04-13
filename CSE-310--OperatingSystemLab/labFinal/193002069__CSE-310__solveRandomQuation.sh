#!/bin/bash
# author: @shmVirus, ID: 193002069, name: Md. Sabbir Hosen Mamun

echo "This script solves this Equation, (a^2*b) + (b^3-c) + (4*a/c)"

until [[ $a =~ [0-9] && ! $a =~ [A-Za-z] ]]; do
    read -p "a=" a
    if [[ ! $a =~ [0-9] || $a =~ [A-Za-z] ]]; then
        echo -ne "Must be a Integer, "
    fi
done
until [[ $b =~ [0-9] && ! $b =~ [A-Za-z] ]]; do
    read -p "b=" b
    if [[ ! $b =~ [0-9] || $b =~ [A-Za-z] ]]; then
        echo -ne "Must be a Integer, "
    fi
done
until [[ $c =~ [1-9] && ! $c =~ [A-Za-z] ]]; do
    read -p "c=" c
    if [[ ! $c =~ [1-9] || $c =~ [A-Za-z] ]]; then
        echo -ne "Must be a Integer > 0, "
    fi
done

echo -ne "Answer: "; expr "scale=2; ($a^2 * $b) + ($b^3 - $c) + (4 * $a / $c)" | bc
