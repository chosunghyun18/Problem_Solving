# 2 차원 배열을  만든후 갈수 있는 노드 정보를 1 로 입력 ,  방문 확인후 재귀 함수로 호출하는방법
"""
N개의 정점과 M개의 간선으로 이루어진 양방향 그래프가 주어졌을 때, 1번 정점에서 시작하여 주어진 간선을 따라 이동했을 때
도달 할 수 있는 서로 다른 정점의 수를 구하는 프로그램을 작성해보세요. (여기서 1번 정점 자기 자신에 도달하는 경우는 가지수에서 제외합니다.)


입력 형식
첫 번째 줄에는 N과 M이 공백을 사이에 두고 주어지고,

두 번째 줄부터는 M개의 줄에 걸쳐 (x, y)가 공백을 사이에 두고 주어집니다.

(x, y)는 두 정점 x, y 가 연결되어 있음을 의미합니다. (x, y) 쌍이 동일한 연결관계가 두 번 이상 주어지는 경우는 없다고 가정해도 좋습니다.

1 ≤ N ≤ 1,000

0 ≤ M ≤ min(10,000 , N*(N-1) / 2)

출력 형식
1번 정점과 연결되어 있는 서로 다른 정점의 수를 출력해주세요.

입출력 예제
예제1
입력:
5 4
1 2
1 3
2 3
4 5

출력: 
2
예제2
입력:
5 4
1 2
4 2
5 3
3 4

출력: 
4
""""

n,m = tuple(map(int,input().split()))

given_info =[tuple(map(int,input().split()))
    for _ in range(m)
]


curr =\
    [
    [0 for _ in range(n) ]for  _ in range(n)
    ]

visited =[False for _  in range(n)]
# not visited  =  False

# both way path way oinfor  mation read in row > column
for x in given_info:
    curr_x = x[0]-1
    curr_y = x[1]-1
    curr[curr_x][curr_y] =1
    curr[curr_y][curr_x] = 1
# get an  in fo and check no
count_n = 0

def dfs(node):
    for x in range(n):
        if (curr[node][x] == 1) and visited[x] == False:
            visited[x] = True
            dfs(x)



visited[0] = True
dfs(0)

print(curr)
print(visited)
for x in visited:
    if x == True:
        count_n += 1

# starttingpoint 1 must be except
count_n-=1

print(count_n)















