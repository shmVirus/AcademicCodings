.MODEL SMALL
.STACK 100H

.DATA
    messageOfTheAuthor      DB  "This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!$"
    newLineVariable         DB  0DH, 0AH, "$"
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        MOV AH, 9H
        LEA DX, messageOfTheAuthor
        INT 21H
        
        LEA DX, newLineVariable
        INT 21H
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
END MAIN