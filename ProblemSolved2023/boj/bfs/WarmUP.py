# # Repractice
# from collections import deque
# #given
# graph = [
#     [],
#     [2,3,8],
#     [1,7],
#     [1,4,5],
#     [3,5],
#     [3,4],
#     [7],
#     [2,6,8],
#     [1,7]
#
# ]
#
# visited = [False]*(len(graph)+1)
#
# # Init data
# visited[1] = True
#
# def bfs(graph,start,visited) :
#      q = deque([start])
#      while q :
#          now =q.popleft()
#          for point in graph[now]:
#              if visited[point] == False :
#                 visited[point] = True
#                 print("new point" ,point)
#                 q.append(point)
#
#
#
#
# bfs(graph,1,visited)

import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())

visited = [[False]*m for _ in range(n)]
graph = [input().replace(""," ").split() for _ in range(n)]
start = (0,0)
dx = [1,-1,0,0]
dy = [0,0,1,-1]


def bfs(graph,start,visited):
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

ans = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == '#' and not visited[i][j]:
            graph , visited =bfs(graph, (i,j), visited)
            ans+=1


print(ans)



