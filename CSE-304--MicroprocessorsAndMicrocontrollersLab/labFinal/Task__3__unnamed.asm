INCLUDE 'EMU8086.inc'
    
.MODEL SMALL
.STACK 100H
.DATA
    arr   DB  'Hello World!$'
    c   DB  ?
    n   DB  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV AH, 01H
        INT 21H
        MOV c, AL
        PRINTN
        
        CALL SCAN_NUM
        MOV n, CL
        DEC CL
        PRINTN
        
        MOV AX, 0
        MOV AL, c
        
        ;MOV arr[CL], AL
        
        LEA SI, arr
        MOV AX, SI
        MOV BX, 0
        MOV BL, n
        ADD AX, BX
        MOV SI, AX
        MOV DX, 0
        MOV DL, c
        MOV SI, DX
        
        MOV DX, OFFSET arr
        MOV AH, 09H
        INT 21H
        
        
        
                
        exit:
            ;PRINTN 'This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!'
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    subs PROC
        
    subs ENDP
    
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN