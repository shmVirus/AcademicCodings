INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H
.DATA
    lastValue       DB  ?
    numberOfValues  DB  ?
    firstNumber     DB  12
    numberByTwo     DB  ?
    firstPart       DB  ?
    secondPart      DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        MOV DL, 10  ;
        MOV BL, 0   ; stores previous value
        PRINTN 'This program finds summation of 12+22+...+N pattern where N must end with 2!'
        PRINT 'Enter a Number: '
        scanNumber:
            MOV AH, 1H
            INT 21H     ; single character input function
            
            CMP AL, 13  ; ASCII(13) == EnterKey, checking if entered pressed
            JE exitScan
            
            MOV AH, 0
            SUB AL, 48  ; converting ASCII value to Decimal
            
            MOV CL, AL  ; storing current value in CL
            MOV AL, BL  ; storing previous value in AL
            
            MUL DL      ; multiplying previous value with 10 as decimal multiplies by 10 when one digit increased
            
            ADD AL, CL  ; AL (totalValue) = AL (previousValue) + CL (newValue)
            MOV BL, AL  ; storing cuurent value as previous value
            
            JMP scanNumber
        exitScan:
            MOV AH, 2H
            MOV DL, 0AH ; newline
            INT 21H
            MOV DL, 0DH ; cret
            INT 21H
            
            MOV lastValue, BL
            MOV AH, 0   ; clearing high of AX
            MOV AL, BL  ; AX (totalValue)
            PRINT 'Given Number: '
            CALL PRINT_NUM
        MOV lastValue, Al
        MOV AH, 2H
        MOV DL, 0AH     ; newline
        INT 21H
        MOV DL, 0DH     ; cret
        INT 21H
        
        MOV AH, 0
        MOV AL, lastValue
        MOV DL, 10
        DIV DL          ; AL = AL / DL, to get number of values
        MOV AH, 0       ; clearing high of AX
        MOV numberOfValues, AL
        PRINT 'Number of Values: '
        CALL PRINT_NUM
        MOV AH, 2H
        MOV DL, 0AH     ; newline
        INT 21H
        MOV DL, 0DH     ; cret
        INT 21H
        
        MOV AH, 0
        MOV AL, numberOfValues
        MOV BL, 2
        DIV BL
        MOV numberByTwo, AL
        
        MOV AH, 0
        MOV AL, firstNumber
        MOV BL, 2
        MUL BL
        MOV firstPart, AL
        
        MOV AH, 0
        MOV AL, numberOfValues
        SUB AL, 1
        MOV BL, 10      ; difference between two numbers
        MUL BL
        MOV secondPart, AL
        
        MOV AH, 0
        MOV AL, firstPart
        MOV BL, secondPart
        ADD AL, BL
        MOV BL, numberByTwo
        MUL BL
        MOV BL, AL
                
        MOV AH, 0       ; clearing high of AX
        MOV AL, BL      ; summation in AL
        PRINT 'Summation with Formula: '
        CALL PRINT_NUM
        MOV AH, 2H
        MOV DL, 0AH     ; newline
        INT 21H
        MOV DL, 0DH     ; cret
        INT 21H
        
        MOV AH, 0
        MOV BL, 0
        MOV CL, 1
        conditionalLoop:
            CMP CL, numberOfValues
            JG exitLoop
            MOV AL, 10
            MUL CL      ; AL = AL * CL  => AL = 10 * CL
            ADD AL, 2   ; AL = AL + 2
            ADD BL, AL  ; BL = BL + AL
            INC CL
            JMP conditionalLoop
        exitLoop:
            MOV AH, 0       ; clearing high of AX
            MOV AL, BL      ; summation in AL
            PRINT 'Summation with ConditionalLoop: '
            CALL PRINT_NUM
            MOV AH, 4CH
        INT 21H
    MAIN ENDP
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN