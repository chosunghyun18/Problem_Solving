


# add function for recursive

def factorial(n) :
    print(n)
    if n <= 1 :
        return 1
    # n != n*n(n-1)
    out =  n*factorial(n-1)
    print("this is out:",out)
    return  out



given = 7
print(factorial(given))





# dfs for 2d deminsial
INF =  999999999999
graph = [
    [0,7,5],
    [7,0,INF],
    [5,INF,0],
]

print(graph)

# make graph  using set (go , cost)

graph = [[]for _ in range(3)]
graph[0].append((1,7))
graph[0].append((2,5))

graph[1].append((0,7))


graph[2].append((0,5))


print(graph)


# DFS  POINT susing stack and check not  visitied node

# 2d linked list  dfs cod

def dfs(graph, v,visited):
    # 현제 노드를 방문 처리
    visited[v] = True
    print(v,end = " ")
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

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
print("----dfs-------------")
visited = [False]*9
dfs(graph,1,visited)

print("This is bfs using deque ")
from collections import deque

def bfs(graph, start,visited):
    queue = deque([start])
    visited[start]  = True
    while queue :
        v = queue.popleft()
        print(v,end=" ")
        for i in graph[v]:
            if not visited[i] :
                queue.append(i)
                visited[i] = True

print("----bfs-------------")
visited = [False]*9
bfs(graph,1,visited)




