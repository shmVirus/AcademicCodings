n=int(input("Length: "))
oddSum=0
evenSum=0
for i in range(n):
    x=int(input("Number: "))
    if x%2 != 0:
        oddSum += x
    else:
        evenSum += x
print("Odd Sum: " + str(oddSum) + " and " + "Even Sum: " + str(evenSum))
