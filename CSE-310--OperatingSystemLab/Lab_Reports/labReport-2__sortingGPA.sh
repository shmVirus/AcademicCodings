#!/bin/bash
# author: @shmVirus
# this script sorts GPA after calculating them


numberToString() {  # fuction to print string instead of number while taking input
    case "$1" in
        1) echo -ne "first";;
        2) echo -ne "second";;
        3) echo -ne "third";;           # since given students 3, so keeping it to 3
        *) echo -ne "unidentified";;    # if more students, list can be expanded here
    esac
}
returnPositionString() {    # function to print position with string
    case "$1" in
        1) echo "First";;
        2) echo "Second";;
        3) echo "Third";;
        *) echo "Unidentified";;
    esac
}

read -p "How many students in the class: " numberOfStudents
declare -a studentName; declare -a studentID; declare -a studentGPA # declaring all in one line

for (( i=0; i<$numberOfStudents; i++ )); do # taking input for each course
    echo -ne "\nEnter "; numberToString $(($i+1)); echo -e " Student Record":
    echo -ne "\tName: "; read tempName; echo -ne "\t"
    repeatedID=1
    while [[ $repeatedID -eq 1 ]]; do   # checking if student ID is repeated
        echo -ne "ID: "; read tempID
        availableInRecord=0
        for j in "${studentID[@]}"; do    # cheking in student list to check repeated ID
            if [[ "$j" == "$tempID" ]]; then
                echo -ne "\tRepeated ID, try again with Different "
                availableInRecord=1
            fi
        done
        if [[ $availableInRecord -eq 0 ]]; then
            repeatedID=0
        fi
    done

    echo -ne "\tHow many courses: "; read numberOfCourses; echo -ne "\t\t"
    tempTotalGrade=0    # vaiable to find total grade while taking each course
    tempTotalCredit=0   # variable to find total credit while taking each course
    declare -a tempCourses; unset tempCourses

    for (( j=0; j<$numberOfCourses; j++ )); do  # taking input for each course
        repeatedcourse=1
        while [[ $repeatedcourse -eq 1 ]]; do   # checking if course ID is repeated
            echo -ne "Course ID: "; read courseID
            availableInRecord=0
            for k in "${tempCourses[@]}"; do  # checking in course list for repeated course
                if [[ "$k" == "$courseID" ]]; then
                    echo -ne "\t\tRepeated Course ID, try again with Different "
                    availableInRecord=1
                fi
            done
            if [[ $availableInRecord -eq 0 ]]; then
                repeatedcourse=0
            fi
        done
        tempCourses[$j]=$courseID   # variable to store courses list, helps finding repeated course
        echo -ne "\t\tCourse Name: "; read courseName
        echo -ne "\t\tCredit: "; read courseCredit
        echo -ne "\t\tGrade: "; read courseGrade; echo -ne "\t\t"

        tempTotalGrade=$(expr "scale=10; $tempTotalGrade+$courseCredit*$courseGrade" | bc)
        tempTotalCredit=$(expr "scale=10; $tempTotalCredit+$courseCredit" | bc)
    done

    studentName[$i]=$tempName
    studentID[$i]=$tempID
    studentGPA[$i]=$(expr "scale=2; $tempTotalGrade/$tempTotalCredit" | bc)

    for (( j=0; j<$i; j++ )); do    # sorting while taking input
        if [[ $(expr "${studentGPA[$i]} > ${studentGPA[$j]}" | bc) -eq 1 ]]; then
            temp=${studentName[$i]}
            studentName[$i]=${studentName[$j]}
            studentName[$j]=$temp

            temp=${studentID[$i]}
            studentID[$i]=${studentID[$j]}
            studentID[$j]=$temp

            temp=${studentGPA[$i]}
            studentGPA[$i]=${studentGPA[$j]}
            studentGPA[$j]=$temp
        fi
    done
done

position=1; echo -ne "\n\nRankings:"
for (( i=0; i<$numberOfStudents; i++ )); do
    echo -ne "\n\tName: ${studentName[$i]}\n\tID: ${studentID[$i]}\n\tGPA: ${studentGPA[$i]}\n\tPosition: "; returnPositionString $position
    if [[ $(expr "${studentGPA[$i+1]} < ${studentGPA[$i]}" | bc) -eq 1 ]]; then
        ((position++))
    fi
done
