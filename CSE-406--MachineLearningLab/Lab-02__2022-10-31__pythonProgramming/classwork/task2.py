n=int(input("Length: "))
for i in range(n):
    x=int(input("Number: "))
    if i == 0:
        smallest = x
    if x < smallest:
        smallest = x
print("Smallest Number: " + str(smallest))
