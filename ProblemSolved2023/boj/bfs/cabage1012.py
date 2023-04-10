
import sys
from collections import deque
re =[]
input =sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(graph,start,visited) :
    q = deque([start])
    visited[start[0]][start[1]] = True
    while q :
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m :
                continue

            if not visited[nx][ny] and graph[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx,ny))


for _ in range(int(input())):
    n, m, c = map(int, input().split())

    visited = [[False] * m for _ in range(n)]
    graph = [[0] * m for _ in range(n)]
    cab = []
    for _ in range(c):
        x, y = map(int, input().split())
        cab.append((x, y))

    for node in cab:
        graph[node[0]][node[1]] = 1
    ans = 0


    for i in range(n ):
        for j in range(m):
            if not visited[i][j] and graph[i][j] == 1:
                bfs(graph, (i, j), visited)
                ans += 1
    re.append(ans)
    cab = []

for n in re:
    print(n)