n=int(input("Length: "))
highest=-1
secondHighest=-1
for i in range(n):
    x=int(input("Number: "))
    if i == 0:
        highest = x
        secondHighest = highest
    else:
        if x > highest:
            secondHighest = highest
            highest = x
print("Second Highest Number: " + str(secondHighest))
