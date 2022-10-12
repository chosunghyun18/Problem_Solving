"""
네 방향 탈출 가능 여부 판별하기
n * m 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출하려고 합니다.
이동을 할 때에는 반드시 상하좌우에 인접한 칸으로만 이동할 수 있으며, 뱀이 있는 칸으로는 이동을 할 수 없습니다. 
예를 들어 <그림 1>과 같이 뱀이 배치 되어 있는 경우 실선과 같은 경로로 탈출을 할 수 있습니다. 
이 때 뱀에게 물리지 않고 탈출 가능한 경로가 있는지 여부를 판별하는 코드를 작성해보세요.

입력 형식
첫번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,

두번째 줄부터 (n+1)번째 줄까지는 각 행에 뱀이 없는 경우 1, 뱀이 있는 경우 0이 입력으로 공백을 사이에 두고 주어집니다. 시작 칸과 끝 칸에는 뱀이 주어지지 않는다고 가정해도 좋습니다.

2 ≤ n, m ≤ 100
출력 형식
좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출 가능한 경로가 있으면 1, 없으면 0을 출력합니다.

입출력 예제
예제1
입력:
5 5
1 0 1 1 1
1 0 1 0 1
1 0 1 1 1
1 0 1 0 1
1 1 1 0 1

출력: 
1
예제2
입력:
5 5
1 0 1 1 1
1 0 1 0 1
1 1 1 0 1
1 0 1 1 0
0 1 1 0 1

출력: 


"""

# ther is a two way to get an info 1. use 2 by 2  demension, second use linked list

# thi is used by linked  list

from collections import deque
q= deque()

n, m = tuple(map(int, input().split()))
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited =[
    [0 for _ in range(m)]  for _ in range(n)
    ]



def cango(x,y):
    if 0<=x<n and 0 <= y < m and not visited[x][y] and grid[x][y]:
        return True
    else: False

def move(x,y):
    visited[x][y] = 1
    q.append((x,y))


def bfs():
    while q :                   ######## point      ###########
        x, y = q.popleft()
        nx,ny= [0, 1, 0, -1], [1, 0, -1, 0]
        for way in range(4):
            next_x , next_y = x+nx[way] ,y+ny[way]
            if cango(next_x,next_y):
                move(next_x,next_y)


visited[0][0] = 1
q.append((0,0))
bfs()

print(visited[n-1][m-1])
