def findWaitingTime(numberOfProcess, arrivalTime, burstTime, waitingTime):
    remainingBurstTime = [0] * numberOfProcess
    for i in range(numberOfProcess):
        remainingBurstTime[i] = burstTime[i]

    numberOfCompletedProcess = 0
    currentTime = 0
    minm = 0
    shortestProcess = 0
    check = False

    while (numberOfCompletedProcess != numberOfProcess):
        for i in range(numberOfProcess):    # traverse each process repeatedly
            if ((burstTime[i] <= currentTime and remainingBurstTime[i] < minm) and remainingBurstTime[i] > 0):
                minm = remainingBurstTime[i]
                shortestProcess = i
                check = True
        if (check == False):
            currentTime += 1
            continue
        remainingBurstTime[shortestProcess] -= 1
        minm = remainingBurstTime[shortestProcess]

        if (minm == 0):
            minm = 999999999

        if (remainingBurstTime[shortestProcess] == 0):
            numberOfCompletedProcess += 1
            check = False

            waitingTime[shortestProcess] = (currentTime+1) - remainingBurstTime[shortestProcess] - arrivalTime[shortestProcess]
        
        currentTime += 1

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
