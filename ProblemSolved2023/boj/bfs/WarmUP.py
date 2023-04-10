import sys
from collections import deque

def solution(data):
    input = sys.stdin.readline
    n, m = map(int, input().split())
    visited = [[False] * m for _ in range(n)]
    graph = [input().replace("", " ").split() for _ in range(n)]

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    ans = 0

    for i in range(n):
        for j in range(m):
            if graph[i][j] == '#' and not visited[i][j]:
                graph, visited = bfs(graph, (i, j), visited,dx,dy)
                ans += 1

    print(ans)


def bfs(graph,start,visited,dx,dy):
    q =deque([start])
    while q :
        now = q.popleft()
        x = now[0]
        y = now[1]
        visited[x][y] = True
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny>= m :
                continue
            if graph[nx][ny] == '#' and visited[nx][ny] == False:
                graph[nx][ny] = "1"
                visited[nx][ny] = True
                q.append((nx,ny))

    return graph , visited





