sequence=int(input("Sequence: "))
first = 0
second = 1
fibonacciSum=0
print("Fibonacci (till) " + str(sequence) + "-th" + "Sequence: ", end="")
for i in range (sequence):
    print(str(fibonacciSum), end="")
    fibonacciSum = first + second
    second = first
    first = fibonacciSum
    if i+1 == sequence:
        print()
    else:
        print(" ", end="")
