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
    a,b,c = map(int,input().split())
    arr[a].append((b,c))



"""
Define function dijkstra
"""

def f(start):
    q = []
    heapq.heappush(q,(0,start))  # [(0, 1)]
    print("heapq:",q)
    while q :
        dist , now = heapq.heappop(q)
        print("dist :",dist,"now : ",now)
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
                print("heapq:", q)




    return start




"""
call result 

"""


f(start)
print("--Output :--")
for i in range(1,n+1) :
    if d[i] == INF  :
        print("can't go")
    else:
        print(d[i])



"""
Test case

6 11
1
1 2 2
1 3 5
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










