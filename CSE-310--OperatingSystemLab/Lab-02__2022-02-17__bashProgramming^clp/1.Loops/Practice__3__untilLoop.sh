#! /bin/bash
#? exploring until-loop syntax

#* opposite of while; while executes when true, until does when false

counter=0
until [ $counter -gt 5 ]; do
    echo Counter: $counter
    ((counter++))
done
