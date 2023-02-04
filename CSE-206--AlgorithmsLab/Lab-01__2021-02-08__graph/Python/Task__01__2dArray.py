size = int(input("Size: "))
matrix = []
for r in range(size):
    tempMatrix = []
    for c in range(size):
        tempMatrix.append(int(input()))
    matrix.append(tempMatrix)
print("AdjacencyMatrix: ")
for r in range(size):
    for c in range(size):
        if c+1 != size:
            print(matrix[r][c], end = " ")
        else:
            print(matrix[r][c])
