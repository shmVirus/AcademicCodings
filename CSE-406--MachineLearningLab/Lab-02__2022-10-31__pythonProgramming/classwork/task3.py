lower=int(50)
upper=int(100)
askedSum=0
for i in range(lower, upper):
    if i%3 == 0 and i%5 != 0:
        askedSum += i
print("Asked Sum: " + str(askedSum))
