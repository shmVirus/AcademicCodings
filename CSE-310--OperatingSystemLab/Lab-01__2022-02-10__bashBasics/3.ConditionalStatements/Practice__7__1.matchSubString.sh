#! /bin/bash
#* match substring with asterisk symbol

#* '*...*' command ignores before and after of asterisk


truth='GNU is recommanded, but not required for Linux!'
if [[ $truth == *"not required"* ]]; then
    echo "Truth is there!"
fi
