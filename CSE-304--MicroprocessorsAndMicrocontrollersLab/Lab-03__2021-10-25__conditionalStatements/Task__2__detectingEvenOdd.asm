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
        MOV BL, 2
        DIV BL
        
        CMP AH, 1
        JE oddNumber:
        MOV AX, CX
        CALL PRINT_NUM
        PRINTN ' is a EVEN Number'
        JMP exit
        
        oddNumber:
        MOV AX, CX
        CALL PRINT_NUM
        PRINTN ' is a ODD Number'
        exit:
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN