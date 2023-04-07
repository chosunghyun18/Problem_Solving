# T = number of test case

# N -> 2, 125   could be 3 loop

import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)


dx = [1,-1,0,0]
dy = [0,0,1,-1]


def sol():
    n = int(input())
    # Make list
    # distance = [[INF]*n]*n  : 한줄 바뀌면 다바뀜
    distance = [[INF]*n for _ in range(n)]
    given_graph = []
    for i in range(n) :
        given_graph.append(list(map(int,input().split())))

    q = []
    start = (0,0)
    start_c = given_graph[0][0]
    distance[0][0] = start_c
    heapq.heappush(q, (start_c,start))
    while q:
        dist , node =heapq.heappop(q)

        if distance[node[0]][node[1]] < dist:
            continue
        for i in range(4):
            nx = node[0] + dx[i]
            ny = node[1] + dy[i]
            if nx < 0 or ny < 0  or nx >= n or ny >= n :
                continue
            cost = dist + given_graph[nx][ny]
            if  cost < distance[nx][ny]:
                distance[nx][ny] = cost
                heapq.heappush(q,(cost,(nx,ny)))
    print(distance[n-1][n-1])



for _ in range(int(input())):
    sol()


"""
Testcase

3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4


"""





"""
Near search shortest cut  - > bfs or dfs
"""