def findSum(numbers):
    listSum=0
    for i in range(len(numbers)):
        listSum += numbers[i]
    return listSum

length=int(input("Length: "))
myList=[] * length
for i in range(length):
    myList.append(int(input('Number: ')))
print("Sum of List: " + str(findSum(myList)))
