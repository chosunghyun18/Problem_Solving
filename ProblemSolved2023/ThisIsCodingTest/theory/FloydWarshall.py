
import sys
input = sys.stdin.readline


INF = int(1e9)
#number of node
n = int(input())
#number of edge
m = int(input())

# 2d
graph = [[INF] *(n+1)for _ in range(n+1)]


# case  same  node is cost  0
for i in range(n+1) :
    graph[i][i] = 0

# input
for _ in range(m) :
    a,b,c = map(int ,input().split())
    graph[a][b] = c


print(graph)
"""
Solution 
"""

def sol(graph):
    # graph[a][b] = min(graph[a][b] , grapth[a][k] + graph[k]][b])
    for k in range(1,n+1):
        for a in range(1, n + 1):
            for b in range(1, n + 1):
                graph[a][b] = min(graph[a][b] ,graph[a][k]+graph[k][b])
    return graph

sol(graph)


"""
Result
"""
for a in range(1,n+1):
    for b in range(1,n +1):
        if graph[a][b] == INF:
            print("can't go")
        else :
            print(graph[a][b] ,end=" ")
    print()





"""
Test Case

4
7
1 2 4 
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4 
4 3 2


"""


