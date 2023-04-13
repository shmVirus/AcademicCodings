INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H

.DATA
.CODE
    MAIN PROC
        PRINT 'Enter a Multi Digit Number: '
        CALL takeNumber
        CALL newLine
        MOV AH, 0H
        MOV AL, BL
        PRINT 'Given Number: '
        CALL PRINT_NUM
        PRINTN
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
        takeNumber PROC
        MOV AL, 0
        MOV DL, 10  ;
        MOV BL, 0   ; stores previous value
        
        scanNumber:
            MOV AH, 1H
            INT 21H     ; single character input function
            
            CMP AL, 13  ; ASCII(13) == EnterKey, checking if entered pressed
            JE exitTakeNumber
            
            ;MOV AH, 0
            SUB AL, 48  ; converting ASCII value to Decimal
            
            MOV CL, AL  ; storing current value in CL
            MOV AL, BL  ; storing previous value in AL
            
            MUL DL      ; multiplying previous value with 10 as decimal multiplies by 10 when one digit increased
            
            ADD AL, CL  ; AL (totalValue) = AL (previousValue) + CL (newValue)
            MOV BL, AL  ; storing cuurent value as previous value
            
            JMP scanNumber
        exitTakeNumber:
            RET
    takeNumber ENDP
    
    newLine PROC
        MOV AH, 2H
        MOV DL, 0AH
        INT 21H
        MOV DL, 0DH
        INT 21H
        RET
    newLine ENDP
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN