INCLUDE 'EMU8086.inc'
    
.MODEL SMALL
.STACK 100H
.DATA
    a   DW  ?
    b   DW  ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        CALL SCAN_NUM
        MOV AX, CX
        PRINTN
        CALL SCAN_NUM
        MOV BX, CX
        PRINTN
        
        MOV CX, AX
        MOV DL, 2
        DIV DL
        CMP AH, 1
        MOV AX, CX
        JE printer
        INC AX
        
        printer:
            CMP AX, BX
            JGE exit
            CALL PRINT_NUM
            ADD AX, 2
            forComma:
                CMP AX, BX
                JGE printNewLine
                printSpace:
                    PRINT ', '
                    JMP exitStyle
                printNewLine:
                    PRINTN
                    JMP exit
            exitStyle:
            JMP printer
                
        exit:
            PRINTN 'This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!'
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN