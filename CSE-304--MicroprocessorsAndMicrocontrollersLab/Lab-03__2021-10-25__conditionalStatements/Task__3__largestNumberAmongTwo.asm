INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
    A   DB  ?
    B   DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Enter first Number: '
        CALL SCAN_NUM
        PRINTN
        MOV A, CL
        
        PRINT 'Enter second Number: '
        CALL SCAN_NUM
        PRINTN
        MOV B, CL
        
        MOV AL, A
        MOV BL, B
        CMP AL, BL
        JGE firstLarge
        MOV AH, 0H
        MOV AL, B
        CALL PRINT_NUM
        PRINTN ' is larger'
        JMP exit
        
        firstLarge:
        MOV AH, 0H
        MOV AL, A
        CALL PRINT_NUM
        PRINTN ' is larger'
        exit:
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN