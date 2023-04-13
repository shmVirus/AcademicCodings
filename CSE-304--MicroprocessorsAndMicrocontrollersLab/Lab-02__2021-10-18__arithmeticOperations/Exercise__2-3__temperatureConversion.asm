INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
    temparature   DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Celsius: '
        CALL SCAN_NUM
        PRINTN
        MOV temparature, CL
        
        MOV AH, 0H
        MOV AL, temparature
        
        MOV BL, 9
        MUL BL
        
        MOV BL, 5
        DIV BL
        
        MOV BL, 32
        ADD AL, BL
        MOV BL, 1
        SUB AL, BL
        MOV AH, 0H
        PRINT 'Fahrenheit: '
        CALL PRINT_NUM
        PRINTN
        
        
        PRINT 'Fahrenheit: '
        CALL SCAN_NUM
        PRINTN
        MOV temparature, CL
        
        MOV AH, 0H
        MOV AL, temparature
        
        MOV BL, 32
        SUB AL, BL
        MOV BL, 5
        MUL BL
        MOV BL, 9
        DIV BL
        MOV BL, 1
        ADD Al, BL
        MOV AH, 0H
        PRINT 'Celsius: '
        CALL PRINT_NUM
        PRINTN
        
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN