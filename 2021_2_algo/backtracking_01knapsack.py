"""


16
4
2 5 10 5
40 30 50 10



1. 첫줄에 배낭 크기 (사이즈 한계)
2. 둘째 줄에 물건 개수
3. 물건들의 크기
4. 물건들의 가치


백트레킹 방법으로 탐색

함수 fractional_knap: 사이즈를 1단위로 분리가능
-> greedy : 단위당 가치가 높은것들로 선택해서 채운다.


knap_sack : 재귀적 방법 x[i] =1 ,x[i]=0 둘다 탐색
상태 트리를 작성 가능하며

한계를 알기 때문에 빠른 탐색이 가능하다.

knapsack <= fractional knapack




"""



def fractional_Knapsack(n, size, profit, K):
        # n개의 아이템, 크기 size[], 가치 profit[], 배낭의 현재 빈 공간 K
        if K <= 0:
                return 0
        s = 0 #(초기 값)
        p = 0 #(초기 값)

        for i in range(n):
                if s + size[i] <= K: # 배낭에 쏙 들어가면 전체 선택
                        p += profit[i]
                        s += size[i]
                else: # 넘치면 잘라서 선택
                        p += (K-s) * (profit[i]/size[i])
                        # print("p:",p)
                        # s = K in case
                        break
        return p



def Knapsack(i, T): # x[i] = 1인 경우와 0인 경우를 각각 시도함
        # T는 배낭의 남은 공간을 의미함
        global MaxProfit
        global solution
        if i >= n or T <= 0:
                return
        s,p = 0,0
        for j in range(i):
                if x[j] == 1 :
                        s += size[j]
                        p += profit[j]

        # 선택일시
        if size[i] <= T: # 계속 탐색해야 한다면
                B = fractional_Knapsack(n-(i+1), size[i+1:], profit[i+1:], T-size[i])
                if p+profit[i]+ B > MaxProfit:
                        MaxProfit = max(MaxProfit,p+profit[i])
                        x[i]=1
                        solution[i] = 1
                        Knapsack(i+1, T-size[i])

        B = fractional_Knapsack(n-(i+1), size[i+1:], profit[i+1:], T)
        if (p + B) > MaxProfit: # 계속 탐색해야 한다면
                x[i] = 0
                solution[i] = 0
                Knapsack(i+1, T)




K = int(input())
n = int(input())
size =  [int(x) for  x in input().split()]
profit =  [int(x) for  x in input().split()]

# 단위당 비싼 순서로 정
data = []
for  i in range(n):
        data.append([size[i] , profit[i]])
data = sorted(data,key=lambda x : x[1]/x[0], reverse=True)

size = []
profit = []

for i in range(n):
        size.append(data[i][0])
        profit.append(data[i][1])

# print(size)
# print(profit)

solution = [0]*(n)
x = [0]*n # 아이템 i가 선택되면 x[i] = 1, 아니면 x[i] = 0이 됨
MaxProfit = 0  #현재까지 가장 큰 가치 값 [전역변수]

Knapsack(0, K) # [주의] 아이템의 번호가 0부터 시작한다고 가정!


print(MaxProfit)
