INCLUDE 'EMU8086.inc'

newLine MACRO
    MOV AH, 2H
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H
newLine ENDM

.MODEL SMALL
.STACK 100H
.DATA
    k   DB  ?
    b   DB  ?
    n   DB  ?
    t   DB  ?
    z   DB  1
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Growth Rate: '
        CALL SCAN_NUM
        MOV k, CL
        newLine
        PRINT 'Abnormal Growth: '
        CALL SCAN_NUM
        MOV b, CL
        newLine
        PRINT 'First Experiment Time: '
        CALL SCAN_NUM
        MOV n, CL
        newLine
        PRINT 'Initial Second Experiment Bacteria: '
        CALL SCAN_NUM
        MOV t, CL
        newLine
        
        MOV CH, 0H
        MOV BL, k
        MOV DL, b
        MOV CL, n
        MOV AL, z
        firstTube:
            MUL BL
            ADD AL, DL
            LOOP firstTube
        MOV AH, 0H
        MOV z, AL           ; total bacteria in first experiment
        
        MOV BH, 0H
        MOV BL, t           ; initial bacteria in second experiment
        
        CMP AL, BL
        MOV SI, 0H
        ; when initial second experiment bacteria >= total first experiment bacteria, required time is 0.
        JLE exit
        
        MOV BL, k
        MOV CL, b
        MOV AL, t
        MOV DL, z
        secondTube:
            CMP AL, DL
            JGE exit
            MUL BL
            ADD AL, CL
            INC SI          ; time to grow more bacteria than first experiment
            JMP secondTube
        exit:
                PRINT 'Time required by Second Experiment: '
                MOV AX, SI
                CALL PRINT_NUM
                newLine
                PRINTN 'This program is written by 193002069 aka Sabbir and 193002070 and Jubayer!'
                MOV AH, 4CH
                INT 21H
    MAIN ENDP

    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN