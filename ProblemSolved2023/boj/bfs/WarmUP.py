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

visited = [False]*(len(graph)+1)

# Init data
visited[1] = True

def bfs(graph,start,visited) :
     q = deque([start])
     while q :
         now =q.popleft()
         for point in graph[now]:
             if visited[point] == False :
                visited[point] = True
                print("new point" ,point)
                q.append(point)




bfs(graph,1,visited)