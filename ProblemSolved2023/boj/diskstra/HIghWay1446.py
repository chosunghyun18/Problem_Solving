import sys
import heapq

input = sys.stdin.readline

INF = int(1e9)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue

        for node in graph[now]:
            cost = dist + node[1]

            if cost < distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(q, (cost, node[0]))



n,d = map(int, input().split())
graph = [[] for _ in range(d+1)]
distance =[INF]*(d+1)

for i in range(d):
    graph[i].append((i+1, 1))

for _ in range(n):
    a, b, c = map(int, input().split())
    if b > d:
        continue
    if b - a <= c:
        continue
    graph[a].append((b, c))




dijkstra(0)
print(distance[d])
