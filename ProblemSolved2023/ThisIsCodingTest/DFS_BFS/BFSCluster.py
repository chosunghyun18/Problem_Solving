from collections import deque

given = [[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0], [0, 1, 1, 1, 0, 0]]
print(given)

n = len(given)
graph = given[:]
visited = [[False]*n for _ in range(n)]

dx =[1,-1,0,0]
dy =[0,0,1,-1]
blocks = []
def bfs(x,y):
    q= deque()
    q.append((x,y))
    block =[]
    while q:
        x,y = q.popleft()
        block.append((x,y))
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny <0 or nx >=n or ny>=n :
                continue
            if graph[nx][ny] == 0 or visited[nx][ny] :
                continue
            visited[nx][ny] = True
            q.append((nx,ny))
    blocks.append(block)


for i in range(n):
    for j in range(n):
        if graph[i][j] == 0 or visited[i][j]:
            continue
        bfs(i,j)
print(blocks)

# [[(0, 0), (0, 1), (0, 0)],,,