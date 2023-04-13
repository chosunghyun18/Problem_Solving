# 1~8
graph = [
    [], # 0
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
visited = [False]*9

def dfs(v):
    # 현제 방문 노드 처리
    visited[v]= True
    print('now : ',v)
    # 노드와 연결된곳 제귀 탐색
    for item in graph[v]:
        if not visited[item]:
            dfs(item)


dfs(1)