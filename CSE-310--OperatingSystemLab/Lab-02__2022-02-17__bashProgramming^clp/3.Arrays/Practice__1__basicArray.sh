#! /bin/bash
#* declaring and accessing static array

#* '*...*' means exact this '...' string
#* '[...]' means each/any of these '.' characters

array=(This code from Mannual 2 modified by @shmVirus!)

# prints all elements of array
echo ${array[@]}    # This code from Mannual 2 modified by @shmVirus! 
echo ${array[*]}    # This code from Mannual 2 modified by @shmVirus! 
echo ${array[@]:0}  # This code from Mannual 2 modified by @shmVirus! 
echo ${array[*]:0}  # This code from Mannual 2 modified by @shmVirus! 

#prints first element of array
echo ${array[0]}    # This
echo ${array}       # This

# prints particular element of array
echo ${array[1]}    # code
echo ${array[6]}    # by
echo ${array[7]}    # @shmVirus!

# prints all elements starting from a particular index
echo ${array[@]:0}  # This code from Mannual 2 modified by @shmVirus!
echo ${array[@]:1}  # code from Mannual 2 modified by @shmVirus! 
echo ${array[@]:2}  # from Mannual 2 modified by @shmVirus! 
echo ${array[0]:1}  # his

# prints elements in range
echo ${array[@]:0:3}    # This code from 
echo ${array[@]:3:2}    # Mannual 2 
echo ${array[@]:5:2}    # modified by
echo ${array[7]:1:8}    # shmVirus

# prints length of particular element
echo ${#array[7]}   # 10, 7-th element '@shmVirus!'
echo ${#array}      # 4, array means array[0]; that is 'This'

# prints size of an array
echo ${#array[@]}   # 8, total elements in array
echo ${#array[*]}   # 8, total elements in array

# search in array; removes elements that contains any of these chars
echo ${array[@]/*[Tfn2]*/}

# replacing substring temporary
echo ${array[@]//i/I}   # replaces all small 'i' with captal 'I'
echo ${array[@]//a/}    # removes all n from the array 
echo ${array[5]//d/D}   # replaces all small 'i' with captal 'I'#
