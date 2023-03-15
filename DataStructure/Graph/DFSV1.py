"""


노드수 , edge 수 , 2차원 배열 이용 양방향 이동 가능  DFs


input :   
4 4
0 1
0 3
3 1
1 2


출력 :탐색 하는 노드의 순서  ,  pre , post count로 도는 순서를 저장후 출력 
0 1 2 3 
[1, 8] [2, 7] [3, 4] [5, 6] 



"""
import sys

sys.setrecursionlimit(5000)


def DFS(G, v):
    global curr_time  # pre, post를 위한 time stamp
    visited[v] = 1
    pre[v] = curr_time
    curr_time += 1

    for w in G[v]:
        if visited[w] != 1:
            DFS(G, w)

    post[v] = curr_time
    curr_time += 1


def DFSAll(G):
    # 그래프 G를 DFS 방문한다
    for v in range(n):
        if visited[v] == False:
            DFS(G, v)


# 입력 처리
n, m = [int(x) for x in input().split()]
G = [[] for _ in range(n)]
print(G)

# G 입력 받아 처리  그래프를 그린다 .
for _ in range(m):
        s, l = [int(x) for x in input().split()]
        G[s].append(l)
        G[l].append(s)

print(G)
for i in range(n):
    G[i].sort()
print(G)

# visited, pre, post 리스트 정의와 초기화
visited = [0 for _ in range(n)]
pre = [0 for _ in range(n)]
post = [0 for _ in range(n)]

# curr_time = 1로 초기화
curr_time = 1

DFSAll(G)

print(pre)
print(post)
# 출력
