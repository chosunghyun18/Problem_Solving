def max_sum(A):
    p = []

    if len(A) == 1:
        return A[0]

    p.append(A[0])

    sum = A[0]
    for x in range(1,len(A)):
        sum=A[x]+sum
        p.append(sum)


    maxtmp =  p[-1]

    for i in range(len(p)):
        for j in range(i, len(p)):
            if i == j:
                if maxtmp < p[j]:
                    maxtmp =p[j]
            else:
                if maxtmp < (p[j] - p[i]):
                    maxtmp = p[j] - p[i]


    return maxtmp


# 최대 구간 합 리턴

A = [int(x) for x in input().split()]
sol = max_sum(A)
print(sol)
