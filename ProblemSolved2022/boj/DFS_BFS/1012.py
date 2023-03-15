#### DFS problem  -> find number of block
import sys

sys.setrecursionlimit(10000)

n = int(input())
test = 0;
ansl=[]

def dfs(x,y):
    m = M
    n = N
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False
    if graph[y][x] == 1:
        graph[y][x] = 0
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False


while(test < n):
    M, N, num = map(int, input().split())
    ans = 0
    graph = [[0] * M for _ in range(N)]
    # get cordinate of cabbage for num times
    for i in range(num):
        xc, yc = map(int, input().split())
        graph[yc][xc] = 1

    # print(pd.DataFrame(graph))

    result = 0
    for i in range(N):  # y
        for j in range(M):  # x
            if dfs(j, i) == True:
                result += 1

    # print(pd.DataFrame(graph))

    ans = result
    ansl.append(ans)
    test+=1

for i in range(len(ansl)):
    print(ansl[i])











