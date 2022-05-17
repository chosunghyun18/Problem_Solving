# 촌수계산
from collections import deque
#여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
# 이동한 정보를 넣어주는 방식 , ,,, ?

# 관계 파악,,   bfs tree



n = int(input())
visit = [0] * n
graph = [[] for _ in range(n)]
start ,end =  map(int , input().split())

start-=1
end-=1

m = int(input())

for _ in range(m):
    x,y = map(int , input().split())
    graph[x-1].append(y-1)
    graph[y-1].append(x-1)

def bfs():
    que = deque([start])
    while que:
        v = que.popleft()
        for i in graph[v]:
            if not visit[i]:
                que.append(i)
                visit[i] = visit[v] + 1


def solv(end):
    # print(start,end)
    bfs()
    if visit[end] == 0:
        return -1
    else:
        return visit[end]

print(solv(end))

# print(visit)






#  solv way i using matrix
#
# import pandas as pd
#
# n = int(input())
# visit = [0] * n
#
# graph = [[0] * n for _ in range(n)]
#
# start ,end =  map(int , input().split())
# # change to ascces by index
# start -= 1
# end   -=1
# # number of edge
# m = int(input())
#
# for _ in range(m):
#     x,y = map(int , input().split())
#     graph[y-1][x-1] = 1
#     graph[x - 1][y - 1] = 1 # matrix is symatric

# columns is sttarting point
#
