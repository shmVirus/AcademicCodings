INCLUDE 'EMU8086.inc'
    
.MODEL SMALL
.STACK 100H
.DATA
    array       DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        takeInput:
            CALL SCAN_NUM
            CALL newLine
            MOV array[SI], CL
            CMP CX, 0
            JE exit
            INC SI
            JMP takeInput
            
        exit:
            LEA SI, array
            CALL findNumberFunc
            
            PRINT 'Smallest: '
            MOV AH, 0H
            MOV AL, BL
            CALL PRINT_NUM
            PRINT ' and '
            PRINT 'Largest: '
            MOV AH, 0H
            MOV AL, DL
            CALL PRINT_NUM
            PRINT ' using Procedure'
            CALL newLine
            PRINTN 'This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!'
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    findNumberFunc PROC
        MOV BL, 0FFH
        MOV DL, 0H
        findNumber:
            MOV CL, [SI]
            CMP CL, 0
            JE exitFunc
            checkSmall:
                CMP CL, BL
                JAE checkLarge
                MOV BL, CL
            checkLarge:
                CMP CL, DL
                JBE exitCheck
                MOV DL, CL
            exitCheck:
                INC SI
                JMP findNumber
        exitFunc:
            RET
    findNumberFunc ENDP
    
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