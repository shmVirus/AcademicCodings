INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
    newLineVariable DB  0DH, 0AH, "$"   ; ODH = cret, OAH = new line; 0DH, 0AH, "$" combined to get new line.
    messageForA     DB  "First Number: $"
    messageForB     DB  "Second Number: $"
    A   DB  ?
    B   DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV AH, 9H
        LEA DX, messageForA
        INT 21H
        
        CALL SCAN_NUM
        MOV A, CL
        
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        
        LEA DX, messageForB
        INT 21H
        
        CALL SCAN_NUM
        MOV B, CL
        
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        
        MOV AH, 0H
        MOV AL, A
        MOV BL, B
        ADD AL, BL
        PRINT 'Addition: '
        CALL PRINT_NUM
        PRINTN
        
        MOV AH, 0H
        MOV AL, A
        MOV BL, B
        SUB AL, BL
        PRINT 'Subtraction: '
        CALL PRINT_NUM
        PRINTN
        
        MOV AH, 0H
        MOV AL, A
        MOV BL, B
        MUL BL
        PRINT 'Multiplication: '
        CALL PRINT_NUM
        PRINTN
        
        MOV AH, 0H
        MOV AL, A
        MOV BL, B
        DIV BL
        MOV CL, AH
        MOV AH, 0H
        PRINT 'Quotient: '
        CALL PRINT_NUM
        PRINTN
        MOV AL, CL
        PRINT 'Remainder: '
        CALL PRINT_NUM
        PRINTN
        
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN