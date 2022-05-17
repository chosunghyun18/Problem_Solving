


n = int(input())
visit = [0] * n

graph = [[] for _ in range(n)]

start ,end =  map(int , input().split())

m = int(input())

for _ in range(m):
    x,y = map(int , input().split())
    graph[x-1].append(y-1)




print(graph)



