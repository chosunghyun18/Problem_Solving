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
print(n,m)

visited = [[0]*m for _ in range(n)]
graph = [input().replace(""," ").split() for _ in range(n)]

start = (0,0)
dx = [1,-1,0,0]
dy = [0,0,1,-1]


def bfs(graph,start,visited):
    count = 0
    q =deque([start])
    while q :
        now = q.popleft()
        x = now[0]
        y = now[1]
        if graph[x][y] == '#' and visited[now[0]][now[1]] == 0:
            count +=1
            for i in range(4):
                x += dx[i]
                y += dy[i]
                if x < 0 or y < 0 or x > n or y> n :
                    continue
                if graph[x][y] == '#' and visited[x][y] == 0:
                    q.append((x,y))
    return count
print(bfs(graph,start,visited))

print(graph)

def solution(data):
    print(bfs(graph, start, visited))
