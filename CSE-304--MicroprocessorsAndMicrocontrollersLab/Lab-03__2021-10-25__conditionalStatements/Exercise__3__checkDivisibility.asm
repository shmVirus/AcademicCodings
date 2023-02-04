INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Enter a Number: '
        CALL SCAN_NUM
        PRINTN
        
        MOV AX, CX
        MOV BL, 5
        DIV BL
        
        CMP AH, 0
        JG notDivisible
        MOV AX, CX
        CALL PRINT_NUM
        PRINTN ' is Divisible by 5'
        JMP exit
        
        notDivisible:
        MOV AX, CX
        CALL PRINT_NUM
        PRINTN ' is not Divisible by 5'
        exit:
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN