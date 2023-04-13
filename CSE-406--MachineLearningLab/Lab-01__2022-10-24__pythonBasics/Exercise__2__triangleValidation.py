a = int(input("First Side: "))
b = int(input("Second Side: "))
c = int(input("Third Side: "))

if a >= b:
    if a >= c:
        valid = True if (b+c > a) else False
    else:   # means c largest 
        valid = True if (a+b > c) else False
else:
    if b >= c:
        valid = True if (a+c > b) else False
    else: #means c largest
        valid = True if (a+b > c) else False
print("Valid Triangle!" if valid else "Invalid Triangle!")
