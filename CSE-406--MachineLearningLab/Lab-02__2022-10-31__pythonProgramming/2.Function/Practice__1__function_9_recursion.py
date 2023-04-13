# Recursion Example
def my_recursion(k):
    if(k > 0):
        result = k + my_recursion(k - 1)
        print(result)
    else:
        result = 0
    return result

print("Recursion Example Results")
my_recursion(6)
