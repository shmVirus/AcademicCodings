vertices = int(input("Vertices: "))
graphList = []
for r in range(vertices):
    tempList = []
    isDone = False
    while not isDone:
        temp = int(input())
        if temp == -1:
            isDone = True
        else:
            tempList.append(temp)
    graphList.append(tempList)
print("AdjacencyList: ")
for r in range(vertices):
    tempLength = len(graphList[r])
    for c in range(tempLength):
        if c+1 != tempLength:
            print(graphList[r][c], end = " ")
        else:
            print(graphList[r][c])

