def findWaitingTime(quantumTime, numberOfProcess, arrivalTime, burstTime, waitingTime):
    remainingBurstTime = [0] * numberOfProcess
    for i in range(0, numberOfProcess):
        remainingBurstTime[i]=burstTime[i]  # copying burst time to remaining burst time as initially both are same
    #remainingBurstTime = []
    #remainingBurstTime = deepcopy(burstTime)   # alternative way of copying array
    
    currentTime = 0 # current time
    done = False    # works as flag for loop
    while not done: # traversing processes in round robin manner till all not done
        done = True
        for i in range(0, numberOfProcess):    # traverse each process repeatedly
            # if burst time of a process is greater than 0 then only need to process further
            if (remainingBurstTime[i] > 0):
                done = False    # there is at least a pending process
                if (remainingBurstTime[i] > quantumTime):
                    # increase the value of current time, it shows how much time a process has been processed
                    currentTime += quantumTime
                    # decrease the burst time of current process by quantum
                    remainingBurstTime[i] -= quantumTime

                # if burst time is smaller than or equal to quantum, then last cycle for this process
                else:
                    # increase the value of current time, it shows how much time a process has been processed
                    currentTime += remainingBurstTime[i]
                    # waiting time is current time minus time used by this process
                    waitingTime[i] = currentTime - burstTime[i] - arrivalTime[i]
                    # as the process gets fully executed make its remaining burst time = 0
                    remainingBurstTime[i] = 0

def findTurnAroundTime(numberOfProcess, burstTime, waitingTime, turnAroundTime):
    # calculating turnaround time by adding burstTime[i] + waitingTime[i]
    for i in range(0, numberOfProcess):
        turnAroundTime[i] = burstTime[i] + waitingTime[i]

def findAverageTime(quantumTime, numberOfProcess, processes, arrivalTime, burstTime):
    waitingTime = [0]*numberOfProcess
    turnAroundTime = [0]*numberOfProcess
    totalWaitingTime = 0
    totalTurnAroundTime = 0

    # function to find waiting time of all processes
    findWaitingTime(quantumTime, numberOfProcess, arrivalTime, burstTime, waitingTime)
    # function to find turn around time for all processes
    findTurnAroundTime(numberOfProcess, burstTime, waitingTime, turnAroundTime)

    # display processes along with all details
    print("\nPID\tAT\tBT\tWT\tTAT")

    # calculate total waiting time and total turn around time
    for i in range(0, numberOfProcess):
        totalWaitingTime += waitingTime[i]
        totalTurnAroundTime += turnAroundTime[i]
        print(" " + str(processes[i]) + "\t" + str(arrivalTime[i]) + "\t" + str(burstTime[i]) + "\t" + str(waitingTime[i]) + "\t" + " " + str(turnAroundTime[i]))
        
    print("\nAWT = %.2f "%(totalWaitingTime / numberOfProcess) )
    print("ATAT = %.2f "% (totalTurnAroundTime / numberOfProcess ))

if __name__ == '__main__':  # main function
    quantumTime = int(input("Quantum Time: "))
    numberOfProcess = int(input("Number of Process: "))

    processes = []
    arrivalTime = []
    burstTime = []

    for i in range(0, numberOfProcess):    # taking inputs for all processes
        print()
        repeatedID=True
        while repeatedID:   # checking if any process ID is repeated or not
            tempID=(input("ID: "))
            availableInRecord=False
            for j in processes:
                if (j == tempID):
                    print("Repeated ID, try again with Different ", end="")
                    availableInRecord=True
            if (availableInRecord == False):
                repeatedID=False

        processes.append(tempID)    # if PID is not repeated, then adding it to list
        arrivalTime.append(int(input("AT: ")))
        burstTime.append(int(input("BT: ")))

    # function to calculate average time
    findAverageTime(quantumTime, numberOfProcess, processes, arrivalTime, burstTime)
