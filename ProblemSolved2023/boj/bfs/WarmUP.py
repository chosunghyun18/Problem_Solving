# Repractice
from collections import deque
#given
graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]

]
INF = int(1e9)

visited = []*len(graph)

def bfs(graph,start,visited) :
     q = deque([start])
     while q :
         now =q.popleft()




bfs(graph,1,visited)