# 작은 것들을 위한 

import numpy as np

def solve(A):
    #A = [1,2,-1,4]
    n=len(A)
    # 배열 만들고
    if n == 1:
        return A[0]
    #dp table

    dpt = [   # min( )  >  # 빠른 초기 화 생각 생성과 동시에 같은 인덱스 대이;ㅂ
        [-1 for _ in range(len(A))]
        for _ in range(len(A))]

    result = 0
    print(np.array(dpt))

    for i in range(n):
        dpt[i][i]=A[i]
        result += A[i]
    # dp  run

    print(np.array(dpt))

    for i in range(n):
        for j in range(i+1, n):
                # 옆에서 오는 경우
                dpt[i][j] = min(dpt[i][j-1] , A[j])
                result +=dpt[i][j]

    print(np.array(dpt))
    # 조합을 뽑 는다
    return result


A = [int(x) for x in input().split()]
print(solve(A))
