def fac(A):
    arr = []
    top = A
    answer =1
    for _ in range(A):
        arr.append(top)
        top-=1


    for x  in arr:
        answer = answer*x

    return answer

def combi(n,r):
    return fac(n+ r -1)/(fac(r-1)*fac(n))

#20 2

n,r = tuple(map(int,input().split()))




print(n,r)
result = int(combi(n,r))
print(int(result % 1000000000))
