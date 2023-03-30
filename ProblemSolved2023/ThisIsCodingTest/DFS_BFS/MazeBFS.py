from collections import deque
n ,m = map(int,input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int,input())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

# count = 0 no count , use variable that was given

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    while queue :
        x, y = queue.popleft()
        for i in range(4):  # search in four way
            nx = + dx[i]
            ny = + dy[i]

            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue # continue == 무시

            if graph[nx][ny] == 0 :  #this is wall
                continue

            if graph[nx][ny] == 1  :
                graph[nx][ny] = graph[x][y]+1
                queue.append((nx,ny))
        return graph[n-1][m-1]



print(bfs(0,0))




