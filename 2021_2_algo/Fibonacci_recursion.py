lst=[]

def fib(n):
    if n <= 1: return n
    return fib(n-1)+fib(n-2)

n=10

for x in range(n,0,-1):

    lst.append(fib(x))

print(lst)
