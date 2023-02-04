.MODEL SMALL
.STACK 100H

.DATA

.CODE
    MAIN PROC
        MOV AH, 1H  ; read a character
        INT 21H

        MOV BL, AL  ; save input character into BL
        
        MOV AH, 2H  ; write a character
        MOV DL, 0DH
        INT 21H     ; without this 21H, a whitespace is printed before output
        MOV DL, 0AH
        INT 21H     ; line 14 to 17 is for new line; where ODH=cret and 0AH=newline ODH>OA.
        
        MOV DL, BL  ; write content of BL
        INT 21H
        
        MOV AH, 4CH ; return control to DOS
        INT 21H
    MAIN ENDP
END MAIN