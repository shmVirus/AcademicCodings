INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H
.DATA
    n       DB ?
    oddSum  DB ?
    evenSum DB ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Enter a Positive Number: '
        CALL takeNumber
        MOV n, BL
        CALL newLine
        
        MOV AH, 0
        MOV AL, n
        CALL doOddSum
        PRINT 'Sum of Odds: '
        MOV AH, 0
        CALL PRINT_NUM
        CALL newLine
        
        MOV AH, 0
        MOV AL, n
        CALL doEvenSum
        PRINT 'Sum of Evens: '
        MOV AH, 0
        CALL PRINT_NUM
        CALL newLine
        
        PRINTN 'This program is written by @shmVirus'
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
    
    doOddSum PROC
        MOV BL, 2
        MOV DL, AL
        DIV BL
        
        MOV BL, 0
        MOV AL, DL
        
        CMP AH, 1
        JE conditionalLoop:
        conditionalLoop:
            ADD BL, AL
            SUB AL, 2
            
            CMP AL, 0
            JLE exitLoop
        JMP conditionalLoop
        exitLoop:
            MOV AL, BL
            RET
    doOddSum ENDP
    
    doEvenSum PROC
        MOV BL, 2
        MOV DL, AL
        DIV BL
        
        MOV BL, 0
        MOV AL, DL
        CMP AH, 0
        JE conditionalLoopE:
        conditionalLoopE:
            ADD BL, AL
            SUB AL, 2
            
            CMP AL, 1
            JLE exitLoopE
        JMP conditionalLoopE
        exitLoopE:
            MOV AL, BL
            RET
    doEvenSum ENDP
    
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN