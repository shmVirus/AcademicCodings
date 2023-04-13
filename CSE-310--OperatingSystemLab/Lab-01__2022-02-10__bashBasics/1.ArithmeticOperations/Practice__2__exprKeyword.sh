#! /bin/bash
#* basic arithmetic operations using 'expr'

#* expr command evaluates a expression and displays it
#* can be said, expr is combination of let and echo

expr 5 + 4      # 9
expr "5 + 4"    # 5 + 4
expr 5+4        # 5+4
#! $1 as 2nd operand forces for argument, as 1st operand argument optional
expr 5 \* $1    # 5*argument; special chars should be escaped/double quoted
expr 11 % 2     # 1

a=$(expr 10 - 3) # $() helps to combine whole expression for a
echo $a          # 7
