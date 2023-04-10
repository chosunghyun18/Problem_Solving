import sys
input = sys.stdin.readline
from collections import deque

"""
10
1 2 0 1 3 2 1 5 4 2
"""

n = int(input())
arr = list(map(int, input().split()))
INF = int(1e9)
graph = [[] for _ in range(n+1)]

distance= [INF]*(n+1)
distance[1] = 0

for i in range(n):
    can_go=arr[i] # cango  1 , i =0
    for j in range(1,can_go+1) :
        if i+1+j < n+1 :
            graph[i+1].append(i+1+j)
        # graph[i + 1].reverse()

def bfs(start,cost) :
    if arr[0] == 0:
        return -1
    q = deque([start])
    while q :
        now = q.popleft()
        for next in graph[now]:
            if  next > n  :
                continue
            if distance[next]  > distance[now] +1:
                distance[next] = distance[now] + 1
                q.append(next)




bfs(1,0)

if distance[n] == INF:
    print("-1")
else:
    print(distance[n])