INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H
.DATA
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        firstFourDigits:
            PRINT 'First Four Digits: '
            CALL SCAN_NUM
            MOV AX, CX
            PRINTN
        lastThreeDigits:
            PRINT 'Last Three Digits: '
            CALL SCAN_NUM
            MOV BX, CX
            PRINTN

        MOV DX, AX  ; backing up first four digits in DX
        addition:
            ADD AX, BX
            PRINT 'Addition: '
            CALL PRINT_NUM
            PRINTN
        MOV AX, DX  ; restoring first four digits

        MOV CX, 07H
        incrementer:
            INC BX  ; incrementing last three digits
            LOOP incrementer
        MOV DX, AX
        MOV AX, BX
        PRINT 'Incremented: '
        CALL PRINT_NUM
        PRINTN
        MOV AX, DX
        
        subtraction:
            SUB AX, BX
            PRINT 'Subtraction: '
            CALL PRINT_NUM
            PRINTN
        MOV DX, AX

        MOV BH, 0H
        MOV BL, 0AH
        MOV CX, 0H
        findLargest:
            CMP AL, 0H
            JE exitFiner
            DIV BL
            CMP AH, CL
            JLE notLargest
            largestDigit:
                MOV CH, 0H
                MOV CL, AH
            notLargest:
                MOV AH, 0H
                JMP findLargest
        exitFiner:
                decrementer:
                DEC DX
                LOOP decrementer
        MOV AX, DX
        PRINT 'Decremented: '
        CALL PRINT_NUM
        PRINTN
        
        exit:
            PRINTN 'This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!'
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN