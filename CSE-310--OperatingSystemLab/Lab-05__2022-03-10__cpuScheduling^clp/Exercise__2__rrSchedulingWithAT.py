def findWaitingTime(quantumTime,numberOfProcess, arrivalTime, burstTime, waitingTime):
    remainingBurstTime = [0] * numberOfProcess
    for i in range(numberOfProcess):
        remainingBurstTime[i]=burstTime[i]  # copying burst time to remaining burst time as intially both are same
    #remainingBurstTime = []
    #remainingBurstTime = deepcopy(burstTime)   # alternative way of copying array
    
    currentTime = 0 # current time
    done = False    # works as flag for loop
    while not done: # traversing processes in round robin manner till all not done
        done = True
        for i in range(numberOfProcess):    # traverse each process repeatedly
            # if burst time of a process is greater than 0 then only need to process further
            if (remainingBurstTime[i] > 0):
                done = False    # there is a pending process
                if (remainingBurstTime[i] > quantumTime):
                    # increase the value of current time, it shows how much time a process has been processed
                    currentTime += quantumTime
                    # decrease the burst time of current process by quantum
                    remainingBurstTime[i] -= quantumTime

                # if burst time is smaller than or equal to quantum, then last cycle for this process
                else:
                    # increase the value of current time, it shows how much time a process has been processed
                    currentTime = currentTime + remainingBurstTime[i]
                    # waiting time is current time minus time used by this process
                    waitingTime[i] = currentTime - burstTime[i] - arrivalTime[i]
                    # as the process gets fully executed make its remaining burst time = 0
                    remainingBurstTime[i] = 0

def findTurnAroundTime(quantumTime, numberOfProcess, arrivalTime, burstTime, waitingTime, turnArroundTime):
    # calculating turnaround time by adding bt[i] + wt[i]
    for i in range(numberOfProcess):
        turnArroundTime[i] = burstTime[i] + waitingTime[i]

# function to calculate average time
def findAverageTime(quantumTime, numberOfProcess, processes, arrivalTime, burstTime):
    waitingTime = [0]*numberOfProcess
    turnAroundTime = [0]*numberOfProcess
    totalWaitingTime = 0
    totalTurnAroundTime = 0

    # function to find waiting time of all processes
    findWaitingTime(quantumTime, numberOfProcess, arrivalTime, burstTime, waitingTime)
    # function to find turn around time for all processes
    findTurnAroundTime(quantumTime, numberOfProcess, arrivalTime, burstTime, waitingTime, turnAroundTime)

    # display processes along with all details
    print("\nPID\tAT\tBT\tWT\tTAT")

    # calculate total waiting time and total turn around time
    for i in range(0, numberOfProcess):
        totalWaitingTime += waitingTime[i]
        totalTurnAroundTime += turnAroundTime[i]
        print(" " + str(i+1) + "\t" + str(arrivalTime[i]) + "\t" + str(burstTime[i]) + "\t" + str(waitingTime[i]) + "\t" + " " + str(turnAroundTime[i]))
        
    print("\nAWT = %.2f "%(totalWaitingTime / numberOfProcess) )
    print("ATAT = %.2f "% (totalTurnAroundTime / numberOfProcess ))

if __name__ == '__main__':
    quantumTime = int(input("Quntum Time: "))
    numberOfProcess = int(input("Number of Process: "))

    processes = []
    arrivalTime = []
    burstTime = []

    for i in range(0, numberOfProcess):
        processes.append(int(input("\nID: ")))
        arrivalTime.append(int(input("AT: ")))
        burstTime.append(int(input("BT: ")))
    findAverageTime(quantumTime, numberOfProcess, processes, arrivalTime, burstTime)