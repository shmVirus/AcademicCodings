#! /bin/bash
#* implementation of switch-case

car="bmw"
case "$car" in
    #* ';;' closes the current entry in the case statement
    "mercedes") echo "Headquarters − Affalterbach, Germany" ;;
    "audi") echo "Headquarters − Ingolstadt, Germany" ;;
    "bmw") echo "Headquarters − Chennai, Tamil Nadu, India" ;;
esac
