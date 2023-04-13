def findWaitingTime(numberOfProcess, arrivalTime, burstTime, waitingTime):
    serviceTime = [0] * numberOfProcess
    serviceTime[0] = 0
    waitingTime[0] = 0
    
    for i in range(1, numberOfProcess):    # traverse each process repeatedly
        serviceTime[i] = serviceTime[i-1]+burstTime[i-1]
        waitingTime[i] = serviceTime[i]-arrivalTime[i]
        
        if (waitingTime[i] < 0):
            waitingTime[i] = 0

def findTurnAroundTime(numberOfProcess, arrivalTime, burstTime, waitingTime, turnArroundTime):
    # calculating turnaround time by adding bt[i] + wt[i]
    for i in range(numberOfProcess):
        turnArroundTime[i] = burstTime[i] + waitingTime[i];

# function to calculate average time
def findAverageTime(numberOfProcess, processes, arrivalTime, burstTime):
    waitingTime = [0]*numberOfProcess
    turnAroundTime = [0]*numberOfProcess
    totalWaitingTime = 0
    totalTurnAroundTime = 0

    # function to find waiting time of all processes
    findWaitingTime(numberOfProcess, arrivalTime, burstTime, waitingTime)
    # function to find turn around time for all processes
    findTurnAroundTime(numberOfProcess, arrivalTime, burstTime, waitingTime, turnAroundTime)

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
    numberOfProcess = int(input("Number of Process: "))

    processes = []
    arrivalTime = []
    burstTime = []

    for i in range(0, numberOfProcess):
        processes.append(int(input("\nID: ")))
        arrivalTime.append(int(input("AT: ")))
        burstTime.append(int(input("BT: ")))
    
    findAverageTime(numberOfProcess, processes, arrivalTime, burstTime)
