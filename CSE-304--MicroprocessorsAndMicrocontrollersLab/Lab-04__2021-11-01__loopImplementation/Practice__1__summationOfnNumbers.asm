INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
    newLineVariable DB  0DH, 0AH, "$"
    loopCounter     DW  5
    number          DW  5
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV CX, number
        sumLoop:
            ADD BX, CX
        LOOP sumLoop
        
        MOV AX, BX
        PRINT 'Summation with Loop: '
        CALL PRINT_NUM
        
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        
        MOV BX, number
        ADD BX, 1
        MOV AX, number
        MUL BX  ; AX = AX * BX
        MOV BX, 2
        DIV BX  ; AX = AX / BX
        PRINT 'Summation without Loop: '
        CALL PRINT_NUM
        
        MOV AH, 4CH
        INT 21H
     
     
     
        
        COMMENT @
        MOV CX, loopCounter
        MOV DL, 48
        
        basicLoop:
            MOV AH, 2H
            INT 21H
            INC DL
        LOOP basicLoop
        @
    MAIN ENDP
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN