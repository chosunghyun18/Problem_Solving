"""
1 ~ 100 사이의 숫자로 이루어진 n * n 크기의 격자판 정보가 주어집니다. 
이때 m개 구슬이 서로 다른 위치에서 시작하여 1초에 한 번씩 상하좌우로 인접한 곳에 있는 숫자들 중 가장 큰 값이 적혀있는 숫자가 있는 
위치로 동시에 이동합니다. 만약 그러한 위치가 여러개 있는 경우, 상하좌우 방향 순서대로 우선순위를 
매겨 가능한 곳 중 우선순위가 더 높은 곳으로 이동합니다. 단, 이때 격자를 벗어나서는 안됩니다.


입력 형식
첫 번째 줄에는 격자의 크기를 나타내는 n과 구슬의 개수를 나타내는 m, 그리고 시간을 나타내는 t값이 각각 공백을 사이에 두고 주어집니다.

두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 공백을 사이에 두고 주어집니다.

그 다음 줄 부터는 m개의 줄에 걸쳐 각 구슬의 시작 위치를 나타내는 r, c 값이 각각 공백을 사이에 두고 주어집니다. r, c는 r행 c열에서 시작함을 의미하며, 모든 구슬의 시작 위치는 다르다고 가정해도 좋습니다. (1 ≤ r, c ≤ n)

2 ≤ n ≤ 20

1 ≤ m ≤ n * n

1 ≤ t ≤ 100

출력 형식
t초 이후 격자판 이후 남아있는 구슬의 수를 출력합니다.

입출력 예제
예제1
입력:
4 3 1
1 2 2 3
3 5 10 15
3 8 11 2
4 5 4 4
2 2
3 4
4 2

출력: 
3
"""



n,m,t= map(int,input().split())

#get grid point number
given_g =[ tuple(map(int,input().split()))
        for _ in range(n)]

# get bid starting point
given_rc =[ tuple(map(int,input().split()))
        for _ in range(m)]

# present
counta = [
    [0 for _ in range(n)]
    for _ in range(n)]

# nextcount
next_count = [
    [0 for _ in range(n)]
    for _ in range(n)
]


#  get bid cordinat
# put 1 in count  초기화
for i in range(m):
    x , y = given_rc[i]
    counta[x-1][y-1] = 1


# follow the rule to move

dirx = [-1,1,0,0]
diry = [0,0,-1,1]
checki = 0

def checkgo(x,y):
    if 0 <= x <= n-1 and  0 <= y <= n-1 :
        return True
    else :
        return False

# 한번 검사
maxtmp = 0
max =0


for _ in range(t):
# step 1
    for x_i in range(n):
        for y_i in range(n):
            if counta[x_i][y_i] == 1:
                for checki in range(4):
                    nx_i = x_i + dirx[checki]
                    ny_i = y_i + diry[checki]
                    if checkgo(nx_i, ny_i):
                        maxtmp = given_g[nx_i][ny_i]
                        if maxtmp > max:
                            max = maxtmp
                            cord_x, cord_y = nx_i, ny_i

                checki, max, maxtmp = 0, 0, 0
                next_count[cord_x][cord_y] += 1

# step2
    for i in range(n):
        for j in range(n):
            if next_count[i][j] > 1:
                next_count[i][j] = 0
    counta = next_count

    # re initialize by 0
    next_count = [
    [0 for _ in range(n)]
    for _ in range(n)]


#step 3

result =0
for i in range(n):
    for j in range(n):
        if counta[i][j] == 1:
            result +=1

print(result)












