import heapq
import  sys

input= sys.stdin.readline

n, m = map(int, input().split())
start = int(input())


graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c  = map(int, input().split())
    graph[a].append((b,c))

INF = int(1e9)
distance = [INF]*(n+1)

distance[start] = 0

def f(start):
    q = []
    heapq.heappush(q,(0,start))
    while q :
        dist , now = heapq.heappop(q)
        if dist > distance[now] :
            continue
        for node in graph[now] :
            cost = dist + node[1]
            if cost < distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(q,(cost,node[0]))


"""
call result 

"""


f(start)
print("--Output :--")
for i in range(1,n+1):
    if distance[i] == INF :
        print("no")

    else:
        print(distance[i])




"""
Test case

6 11
1
1 2 2
1 3 5git 
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2


"""
