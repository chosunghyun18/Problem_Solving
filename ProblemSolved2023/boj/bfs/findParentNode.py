
import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
visited =[False]*(n+1)
visited[1] = True
ans =[0]*(n+1)

for _ in range(n-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)


# [[], [6, 4], [4], [6, 5], [1, 2, 7], [3], [1, 3], [4]]

def bfs(start) :
    q = deque([start])
    while q :
        node = q.popleft()
        a = node
        for i in graph[node] :
            if not visited[i]:
                ans[i] = a
                q.append(i)
                visited[i]= True



bfs(1)
for i in range(2,n+1):
    print(ans[i])