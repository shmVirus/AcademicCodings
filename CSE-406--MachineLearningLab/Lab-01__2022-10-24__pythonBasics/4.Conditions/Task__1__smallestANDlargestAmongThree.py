a = int(input("First Number: "))
b = int(input("Second Number: "))
c = int(input("Third Number: "))


largest = (a if (a > b and a > c) else (b if (b > c) else c))
print("Largest Number: " + str(largest))

smallest = (a if (a < b and a < c) else (b if (b < c) else c))
print("Smallest Number: " + str(smallest))
