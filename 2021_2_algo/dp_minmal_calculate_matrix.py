
""""

https://youtu.be/8Ni1gaP35i8/


input :
3.    # 행렬의 개수
10 100 5 50     # 행렬의 행과 열의 크기  p1~pn


n 개의 행렬 곱셈 m1 ~ mn 까지 최소 비용을 최소화 하는 문제



point 1. dp 식 ?

dp[i][j] = min( 연산 i~k  ) + min(k~j) + 연산 1~n    



point 2.순서 matrix 역삼각형


   0  1  2  3  4  5
0  0  1  2  3  4  5
1  0  0  1  2  3  4
2  0  0  0  1  2  3
3  0  0  0  0  1  2
4  0  0  0  0  0  1
5  0  0  0  0  0  0



""""










import math

def matrix_mult(n,p,c):
    nt = 0
    for x in range(n - 1, -1, -1):
        print(x)
        nt += 1
        # x = 5
        for i in range(x):
            j = i +nt
            tmp = []
            for k in range(i, j):
                cost = p[i] * p[k + 1] * p[j + 1]
                tmp.append(c[i][k] + c[k + 1][j] + p[i] * p[k + 1] * p[j + 1])
                if i == 1 and j == 3:
                    print(tmp)
                if not len(tmp) == 0:
                    print(tmp)
                    mint = min(tmp)
                    c[i][j] = mint
    return c[0][n - 1]

# n = int(input()) # n = 행렬 갯수, M_0부터 행렬시작임을 주의!
# p = [int(x) for x in input().split()] # M_i = p_i x p_{i+1}

n = 6
p = [2,5,3,5,10,2 ,4]

c = [[0]*n for _ in range(n)] # 비용을 저장할 2차원 리스트 C 초기화

min_cost = matrix_mult(n,p,c)
print(min_cost)
