INCLUDE 'EMU8086.inc'
    
.MODEL SMALL
.STACK 100H
.DATA
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV AX, 0
        
        PRINT 'Attendance (out of 10) - '
        CALL SCAN_NUM
        ADD AX, CX
        PRINTN
        PRINT 'Lab Report (out of 20) - '
        CALL SCAN_NUM
        ADD AX, CX
        PRINTN
        PRINT 'Lab Performance (out of 15) - '
        CALL SCAN_NUM
        ADD AX, CX
        PRINTN
        PRINT 'Lab Project (out of 25) - '
        CALL SCAN_NUM
        ADD AX, CX
        PRINTN
        PRINT 'Lab Final (out of 30) - '
        CALL SCAN_NUM
        ADD AX, CX
        PRINTN
        
        PRINT 'Obtained mark (out of 100) - '
        CALL PRINT_NUM
        PRINTN
        
        CMP AX, 80
        JGE G1
        CMP AX, 75
        JGE G2
        CMP AX, 70
        JGE G3
        CMP AX, 65
        JGE G4
        CMP AX, 60
        JGE G5
        CMP AX, 55
        JGE G6
        CMP AX, 50
        JGE G7
        CMP AX, 45
        JGE G8
        CMP AX, 40
        JGE G9
        JMP G10
        
        
        G1:
            PRINTN 'Obtained grade - A+'
            JMP exit
        G2:
            PRINTN 'Obtained grade - A'
            JMP exit
        G3:
            PRINTN 'Obtained grade - A-'
            JMP exit
        G4:
            PRINTN 'Obtained grade - B+'
            JMP exit
        G5:
            PRINTN 'Obtained grade - B'
            JMP exit
        G6:
            PRINTN 'Obtained grade - B-'
            JMP exit
        G7:
            PRINTN 'Obtained grade - C+'
            JMP exit
        G8:
            PRINTN 'Obtained grade - C'
            JMP exit
        G9:
            PRINTN 'Obtained grade - D'
            JMP exit
        G10:
            PRINTN 'Obtained grade - F'
            JMP exit
                
        exit:
            ;PRINTN 'This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!'
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    DEFINE_SCAN_NUM
    DEFINE_PRINT_NUM
    DEFINE_PRINT_NUM_UNS
END MAIN