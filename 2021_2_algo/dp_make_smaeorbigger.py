
"""
주어진 배열, 다음수가 크거나 작게 만든다.
회수 출력

ex) 1 2 3 4 5
>>>>>0


ex) 1 2 3 2 1 
>>>>2
 1 2 2 2 1
 
 
 풀이 : dp 테이블 작성
 
 
 [[0 1 2 1 0]
 [1 0 1 0 1]
 [2 1 0 1 2]]
 
 >>> 올수 있는 경우 1, 왼쪽에서 바로   2, 외쪽 위  min 값을 저장 
 오름 차순이 성립시 다음 수만 맞추면 전부 오름 차순이다.
 
 

"""

import numpy as np


def check(A):
    check = 0  # 오름 차순 이면 1을 반환
    for x in range(len(A) - 1):
        if A[x] > A[x + 1]:
            return 1  # 오름 차순이 아니
    return check


def solve(A):
    if len(A) == 1:
        return 0

    if check(A) == 0:
        return 0

    min_cnt = 0
    max_a = max(A)  # O(n)

    dpt = [  # input int intterval start in 1         n x m matrix  n = number of list, m = max num
        [-1 for _ in range(len(A))]
        for _ in range(max_a)]
    dpt2 = np.array(dpt)
    print(dpt2)

    # A 에 맞춰 수행 시간 대입   |A[x]- k |
    for x in range(len(A)):
        for k in range(max_a):
            dpt[k][x] = abs(A[x] - (k + 1))
    dpt2 = np.array(dpt)
    print(dpt2)

    # dp  수행 ,  오름차순 ,같거나 크다 , > x번째 수는 x-1 번째 로부터 작거나 같은 수

    for j in range(1, len(A)):  # [][j+1] go right m

        for i in range(max_a):  # [i+1][] go down n
            # 왼쪽 위에서 오는 경우
            if i == 0:  # not 단일 could be alot
                left_up = dpt[i][j - 1]
                tmpm = dpt[i][j - 1]

            else:  # i >= 1    ,  [0 ~ i-1][j-1] 중 min
                left_up=min(dpt[i-1][j - 1],tmpm)
                tmpm=left_up
            # ->
            left = dpt[i][j - 1]
            dpt[i][j] = dpt[i][j] + min(left_up, left)

    dpt2 = np.array(dpt)
    print(dpt2)

    answ = []
    for i in range(max_a):
        answ.append(dpt[i][len(A) - 1])

    return min(answ)


A = [int(x) for x in input().split()]
print(solve(A))



