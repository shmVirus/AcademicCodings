INCLUDE 'EMU8086.inc'
.MODEL SMALL
.STACK 100H
.DATA
    a   DB  ?
    b   DB  ?
    f   DB  ?
    k   DB  ?
    
    totalRefuels    DB  ?
    fuelNeeded      DB  ?
    currentFuel     DB  ?   
    i   DB  1
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        PRINT 'Journey Endpoint: '
        CALL SCAN_NUM
        MOV a, CL
        CALL newLine
        PRINT 'Tank Capacity: '
        CALL SCAN_NUM
        MOV b, CL
        CALL newLine
        PRINT 'Station Point: '
        CALL SCAN_NUM
        MOV f, CL
        CALL newLine
        PRINT 'Journeys Required: '
        CALL SCAN_NUM
        MOV k, CL
        CALL newLine      
        
        MOV AL, b
        MOV BL, f
        CMP AL, BL              ; check if station is reachable at first journey 
        JGE calculateRefuels
        MOV totalRefuels, -1    ; if station unreachable at first journey, then any journey not possible
        JMP exit
        calculateRefuels:
            MOV totalRefuels, 0
            MOV fuelNeeded, 0
            MOV AL, b
            MOV BL, f
            SUB AL, BL
            MOV currentFuel, AL ; fuel level after reaching station at first journey
            
            MOV AL, i
            MOV CL, k
            userLoop:
                CMP AL, CL
                JG exit
                checkForwardBackward:   ; checks current journey forward or backward
                    MOV AH, 0
                    MOV AL, i
                    MOV BL, 2
                    DIV BL
                    CMP AH, 1
                    JL backwardJourney
                    forwardJourney:
                        MOV AL, i
                        MOV BL, k
                        CMP AL, BL
                        JL journeyBackwardRemainging
                        journeyBackwardNotRemainging:
                            MOV AL, a
                            MOV BL, f
                            SUB AL, BL
                            MOV fuelNeeded, AL  ; fuel needed to reach end point from station
                            JMP exceedCapacityORnot
                        journeyBackwardRemainging:
                            MOV AL, a
                            MOV BL, f
                            SUB AL, BL
                            MOV BL, 2
                            MUL BL
                            MOV fuelNeeded, AL  ; fuel needed to reach station after reaching end point
                
                exceedCapacityORnot:            ; checks if needed fuel exceeds tank capacity or not
                    MOV AL, fuelNeeded
                    MOV BL, b
                    CMP AL, BL
                    JLE notExceedCapacity
                    exceedCapacity:
                        MOV totalRefuels, -1        ; if needed fuel to reach start/end/station > tank capacity
                        JMP exit
                    notExceedCapacity:
                        MOV AL, fuelNeeded
                        MOV BL, currentFuel
                        CMP AL, BL
                        JLE calculateCurrentFuel    ; when needed fuel for next point <= current fuel, no need for refuel
                countRefills:
                    MOV AL, b
                    MOV currentFuel, AL
                    MOV AL, totalRefuels
                    INC AL                          ; when needed fuel for next point > current fuel, do refuel
                    MOV totalRefuels, AL
                    JMP calculateCurrentFuel
                nextJourney:
                    MOV AL, i
                    INC AL
                    MOV i, AL
                    MOV AL, i
                    MOV CL, k
                    JMP userLoop

                    backwardJourney:
                        MOV AL, i
                        MOV BL, k
                        CMP AL, BL
                        JL journeyForwardRemainging
                        journeyForwardNotRemainging:
                            MOV AL, f
                            MOV fuelNeeded, AL  ; fuel needed to reach start point from station
                            JMP exceedCapacityORnot
                        journeyForwardRemainging:
                            MOV AL, f
                            MOV BL, 2
                            MUL BL
                            MOV fuelNeeded, AL  ; fuel needed to reach station after reaching start point
                            JMP exceedCapacityORnot
                calculateCurrentFuel:
                    MOV AL, currentFuel
                    MOV BL, fuelNeeded
                    SUB AL, BL
                    MOV currentFuel, AL             ; current fuel after reaching start/end/station
                    JMP nextJourney
        exit:
                MOV AH, 0
                MOV AL, totalRefuels
                PRINT 'Total Refills: '
                CMP AL, -1
                JE notPossible
                possible:
                    CALL PRINT_NUM
                    JMP exitPrint
                notPossible:
                    PRINT '-1'
                exitPrint:
                    PRINTN
                    PRINTN 'This program is written by 193002069 aka Sabbir and 193002070 and Jubayer!'
                    MOV AH, 4CH
                    INT 21H
    MAIN ENDP
    
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