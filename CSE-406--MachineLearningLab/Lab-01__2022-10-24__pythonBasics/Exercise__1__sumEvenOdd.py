list = []
index = 0
oddSum = 0
evenSum = 0
#while (number := int(input())):    # TODO: learn about input in while loop
while True:
    number = input("Enter a Number (or q): ")
    if number == 'q':
        break
    number = int(number)
    list.append(number)
    if (list[index] % 2 != 0):
        oddSum += list[index]
    else:
        evenSum += list[index]
    #(oddSum += int(list[index])) if (list[index] % 2 != 0) else (evenSum += int(list[index])) # TODO: learn about arithmetic operation with ternary operator
    index += 1
print("Odd Sum: " + str(oddSum) + "\nEven Sum: " + str(evenSum))
