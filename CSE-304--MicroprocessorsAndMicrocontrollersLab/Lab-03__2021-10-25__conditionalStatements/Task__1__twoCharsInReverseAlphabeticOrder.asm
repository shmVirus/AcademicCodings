;This code is written by @shmVirus

.MODEL SMALL    ; code type
.STACK 100H     ; stack size, to store addresses

.DATA           ; data segment part, declaration and initialization of variables
    messageFirstCharacter       DB  "First Letter of Your Name: $"
    messageSecondCharacter      DB  "Second Letter of Your Name: $"
    messageForAlphabaticOrder   DB  "Reverse Alphabetic Order of given Letters: $"
    messageOfTheAuthor          DB  "This code is written by 193002069__@shmVirus aka Md. Sabbir Hosen Mamun!$"
    newLineVariable             DB  0DH, 0AH, "$"   ; ODH = cret, OAH = new line; 0DH, 0AH, "$" combined to get new line.

.CODE
    MAIN PROC                   ; PROC defines a procedure
        MOV AX, @DATA           ; moves data to accumulator
        MOV DS, AX              ; DS points to data segment
        
        MOV AH, 9H              ; value 9H in AH enables string funtion
        LEA DX, newLineVariable ; LEA loads pointer/address whereas MOV loads value
        INT 21H                 ; calls interrupt handler
        
        LEA DX, messageFirstCharacter   ; prints contents of messageFirstCharacter
        INT 21H
        
        MOV AH, 1H              ; value 1H in AH enables string funtion
        INT 21H
        
        MOV BL, AL              ; moves data from AL to BL
        
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        ; didn't need to enable string function, as it is already enabled
        LEA DX, messageSecondCharacter
        INT 21H
        ; enabling input function again
        MOV AH, 1H
        INT 21H
        
        MOV BH, AL
        
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        LEA DX, messageForAlphabaticOrder
        INT 21H
        
        MOV AH, 2H              ; value 2H in AH enables output funtion
        
        CMP BL, BH              ; comparing BL with BH aka BL >= BH for JAE
        
        JAE whenLarge
        ; DX/DH/DL is data register for input output port
            MOV DL, BH          ; prints content of BL
            INT 21H
            
            MOV DL, BL          ; prints content of BH
            INT 21H
            
            JMP exitJump        ; JMP unconditional jumps, works like goto of c
            
        whenLarge:
            MOV DL, BL
            INT 21H
            
            MOV DL, BH
            INT 21H
            
        exitJump:
       
        MOV AH, 9H
        LEA DX, newLineVariable
        INT 21H
        LEA DX, messageOfTheAuthor
        INT 21H
        
        MOV AH, 4CH             ; gives control back to the os
        INT 21H
    MAIN ENDP
END MAIN