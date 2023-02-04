;Note: this code works only for 2 digit results
.MODEL SMALL
.STACK 100H

.DATA
    A   DW  9
    B   DW  5
    R   DW  ?   ; we give "?" when we don't initialize the valu
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV AX, A
        MUL B           ; here, MUL B means AX = AX*B
        
        MOV BL, 10
        DIV BL
        
        MOV CL, AH      ; remainder in AH, quotient in AL after DIV BL
        
        MOV AH, 2H
        
        MOV DL, AL
        ADD DL, 30H
        INT 21H
        
        MOV DL, CL
        ADD DL, 30H
        INT 21H
        
        MOV AX, 4CH
        INT 21H
    MAIN ENDP
END MAIN