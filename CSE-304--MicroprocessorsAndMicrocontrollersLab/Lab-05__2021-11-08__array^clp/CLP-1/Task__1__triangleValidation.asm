INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H
.DATA
    a   DB  ?
    b   DB  ?
    c   DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'First Side: '
        CALL takeNumber
        MOV a, BL
        CALL newLine
        
        PRINT 'Second Side: '
        CALL takeNumber
        MOV b, BL
        CALL newLine
        
        PRINT 'Third Side: '
        CALL takeNumber
        MOV c, BL
        CALL newLine
        
        MOV AL, a
        MOV BL, b
        CMP AL, BL
            JB compareBandC
            MOV AL, a
            MOV BL, c
            CMP AL, BL
                JB cBiggest:
                MOV AL, b
                MOV BL, c
                ADD AL, BL
                MOV BL, a
                JMP checkValidity
                cBiggest:
                    MOV AL, a
                    MOV BL, b
                    ADD AL, BL
                    MOV BL, c
                    JMP checkValidity
                    
        compareBandC:
            MOV AL, b
            MOV BL, c
            CMP AL, BL
                JB cBiggest:
                MOV AL, a
                MOV BL, c
                ADD AL, BL
                MOV BL, b
                JMP checkValidity
        
        checkValidity:
            CMP AL, BL
                JBE inValidTriangle
                PRINTN 'Valid Triangle!'
                JMP exit
            
        inValidTriangle:
            PRINTN 'Invalid Triangle!'
       
        exit:
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
    
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN