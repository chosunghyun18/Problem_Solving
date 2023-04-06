import heapq
"""
Ready to get input call import
"""
import sys
input = sys.stdin.readline
INF = int(1e9) # 10 억

"""
Ready to get input
"""
# n = node ,. m = edge
n, m = map(int,input().split())

start = int(input())


arr = [[] for _ in range( n+1 )] # 그래프
d = [INF] * (n+1)

d[start] = 0  # init starting point

#get edge
for _ in range(m) :
    a,b,c = map(int,input().sploit())
    arr[a].append((b,c))



"""
Define function dijkstra
"""

def f(start):
    q = []
    heapq.heappush(q,(0,start))
    print(heapq)
    while q :
        dist , now = heapq.heappop(q)
        print(dist,now)
        # if current node is already vosited just skip
        if d[now] < dist :
            continue
        # check near node in current node
        for i in arr[now] :
             cost = dist+ i[1]
        # 현제 노드를 거쳐서 , 다른 노드로 이동하는 거리가 더 짧은 경우
        if  cost < d[i[0]] :
            d[i[0]] = cost
            heapq.heappush(q,(cost,i[0]))




    return start




"""
call result 

"""


f(start)

for i in range(n+1) :
    if d[i] == INF  :
        print("can't go")
    else:
        print(d[i])














