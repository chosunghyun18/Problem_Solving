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
    return fac(n)/(fac(r)*fac(n-r))


n,r = tuple(map(int,input().split()))

print(combi(n,r))
