#! /bin/bash
#* displays student's grade using switch case

#* BASH doesn't have goto/jump
#* in 'case)' we can't use conditions

read -p "Marks: " marks
if [[ $marks -ge 0 && $marks -le 100 ]]; then
    mark=`echo "scale=0; $marks/10" | bc`
    echo -ne "\033[36;1mGrade: \033[0m"
    case "$mark" in
        10) echo "A+";;
        9) echo "A+";;
        8) echo "A+";;
        7)
            if [[ $marks -ge 75 ]]; then
                echo "A"
            else
                echo "A-"
            fi
        ;;
        6)
            if [[ $marks -ge 65 ]]; then
                echo "B+"
            else
                echo "B"
            fi
        ;;
        5)
            if [[ $marks -ge 55 ]]; then
                echo "B-"
            else
                echo "C+"
            fi
        ;;
        4)
            if [[ $marks -ge 45 ]]; then
                echo "C"
            else
                echo "D"
            fi
        ;;
        3) echo "F";;
        2) echo "F";;
        1) echo "F";;
        0) echo "F";;
    esac
else
    echo -e "\033[31;1;5mInvalid Marks! Try again with other Marks!\033[0m"
fi
