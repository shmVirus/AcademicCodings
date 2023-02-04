#! /bin/bash
#* nested functions invoking

functionOne () {
    echo "Hello $1 from main Branch!"
    functionTwo $1
}

functionTwo () {
    echo "Hello $1 from secondary Branch!"
}


read -p "Name: " name
functionOne $name
