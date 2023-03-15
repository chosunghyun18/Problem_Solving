"""
n ,g

n = [1,2,3,15,15,13,22,1,3]
g = 3


출력 : Total group sum of each group sum of error square




n의 숫자를 최대 g 개 만큼의 그룹으로 묶을 수 있으며 최대한 빈도수가 비슷하게 묶는다 

1 차원 cluster mean




"""
import pandas as pd
L=[1,2,3,4,5,6,7,8,9]
g=4
n = len(L)

# inputg = input().split()
# g , n = int(inputg[0]),int(inputg[1])
# for _ in range(n):
# 	L.append(int(input()))

# grouping table

dpm = [  # DP table of mean
	[0 for _ in range(len(L))]
	for _ in range(len(L) + 1)]
for x in range(n):
	dpm[0][x] = L[x]

# dpc  =  dp table for calculate of  combine using by dp  ignite type 
dpc = [
	[99999 for _ in range(n)] for  _  in range(g)]


dpco = pd.DataFrame(dpc)
print(dpco)


for i in range(1, len(L) + 1):
	m_t_1 = dpm[0][i-1]  # 평균 초기값 세팅    t- 1 시점
	t = 1  # t- 1 시점
	for j in range(i, len(L)):
		# t-1 의 값들 > t 로 갱신
		t = t + 1
		new = dpm[0][j]
		m_t = ((m_t_1 * (t - 1)) + dpm[0][j]) * (1 / t)
		a = ((dpm[0][j]) * (dpm[0][j]) - (t * m_t * m_t) + ((t - 1) * m_t_1 * m_t_1))
		dpm[i][j] = dpm[i][j - 1] + a
		dpm[i][j] = round(dpm[i][j], 3)
		m_t_1 = m_t


dpo = pd.DataFrame(dpm)
print(dpo)

if g == n :
	sum =0
	for x in range(1,n):
		sum += dpm[x][x]
	print(sum)


if g == 2 :
	b =[]
	for x in range(1,n):
		b.append(dpm[1][x-1]+dpm[x+1][n-1])
	print(min(b))


if g == 3  :
	b = []
	for x in range(1, n):
		b.append(dpm[1][x - 1] + dpm[x + 1][n - 1])
	tmp =[]
	for i in range(0,n-(2)):
		for j in range(i+1,n-1):
			tmp.append(dpm[1][i] + dpm[i+2][j] + dpm[j + 2][n-1])
		b.append(min(tmp))
		tmp=[]

	print(min(b))

# dpm groping over 4
# n-1 숫자들의 k-1 까지의 그룹중 작은거

if g == 4 :
	b = []
	for x in range(1, n):
		b.append(dpm[1][x - 1] + dpm[x + 1][n - 1])
	tmp = []
	for i in range(0, n - (2)):
		for j in range(i + 1, n - 1):
			tmp.append(dpm[1][i] + dpm[i + 2][j] + dpm[j + 2][n - 1])
		b.append(min(tmp))
		tmp = []
	tmp = []
	for i in range(0, n - (3)):
		for j in range(i + 1, n - 2):
			for k in range(j + 1, n - 1):
				tmp.append(dpm[1][i] + dpm[i + 2][j] + dpm[j + 2][k] + dpm[k + 1][n - 1])
		b.append(min(tmp))
		tmp = []
		print(b)
	print(min(b))


# make a new dp table
# dp[n][r]

if g == 5 :
	b = []
	for i in range(1, n):
		b.append(dpm[1][i - 1] + dpm[i + 1][n - 1])

	tmp = []
	for i in range(0, n - (2)):
		for j in range(i + 1, n - 1):
			tmp.append(dpm[1][i] + dpm[i + 2][j] + dpm[j + 2][n - 1])
		b.append(min(tmp))
		tmp = []

	tmp = []
	for i in range(0, n - (3)):
		for j in range(i + 1, n - 2):
			for k in range(j + 1, n - 1):
				tmp.append(dpm[1][i] + dpm[i + 2][j] + dpm[j + 2][k] + dpm[k + 1][n - 1])
		b.append(min(tmp))
		tmp = []

	tmp = []
	for i in range(0, n - (4)):
		for j in range(i + 1, n - 3):
			for k in range(j + 1, n - 2):
				for p in range(k + 1, n - 1):
					tmp.append(dpm[1][i] + dpm[i + 2][j] + dpm[j + 2][k]+dpm[k + 2][p]+dpm[p+1][n-1])
		b.append(min(tmp))
		tmp = []


		
		
		
		
"""

######## dp answ ####

import math

B,n = [int(x) for x in input().split()]
F =[0]*(n+1)
for i in range(1,n+1):
    F[i] = int(input())

ps , pps = [00.0]*(n+1), [0]*(n+1)
for i in range(1,n+1):
    ps[i] = ps[i-1] +F[i]
    pps[i] = pps[i-1] +F[i]**2

def sse(i,j):
    return pps[j]-pps[i-1]-(ps[j]-ps[i-1])**2/(j-i+1)

def solve():
    DP = [[0.0] for _ in range(B+1) for _ in range(n+1)]
    for k in range(1,B+1):
        for i in range(1,n+1):
            if k ==1 :
                DP[i][k] = sse(1,i)
            else:
                DP[i][k] = math.inf
                for j in range(1,i):
                    DP[i][k] = min(DP[i][k],DP[j][k-1]+sse(j+1,i))
    return DP[n][B]


ans = solve()
print(round(ans,3))


"""

