number=int(input("Number: "))
factorial=number
for i in reversed(range(1,number)):
    factorial *= i
print("Factorial: " + str(factorial))
