#! /bin/bash
#* displays student's grade using switch case

#? why doesn't work with [75-79], but works with *[75-79]
#? why isn't break meaningful in case for bash?

read -p "Marks: " marks

if [[ $marks -ge 0 && $marks -le 100 ]]; then
    echo -ne "\033[36;1mGrade: \033[0m"
    case "$marks" in
        100 | 9[0-9] | 8[0-9]) echo "A+";;
        7[5-9]) echo "A";;
        7[0-4]) echo "A-";;
        6[5-9]) echo "B+";;
        6[0-4]) echo "B";;
        5[5-9]) echo "B-";;
        5[0-4]) echo "C+";;
        4[5-9]) echo "C";;
        4[0-4]) echo "D";;
        *) echo "F";;
    esac
else
    echo -e "\033[31;1;5mInvalid Marks! Try again with other Marks!\033[0m"
fi
