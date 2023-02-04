def findLargest(a, b):
    if (a > b):
        return a
    else:
        return b

a=int(input("a = "))
b=int(input("b = "))

print("Largest: " + str(findLargest(a, b)))
