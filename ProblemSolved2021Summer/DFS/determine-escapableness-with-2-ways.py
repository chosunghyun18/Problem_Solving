"""
n * m 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출하려고 합니다. 
이동을 할 때에는 반드시 아래와 오른쪽 2방향 중 인접한 칸으로만 이동할 수 있으며, 뱀이 있는 칸으로는 이동을 할 수 없습니다. 


입력 형식
첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,

두 번째 줄부터 (n+1)번째 줄까지는 각 행에 뱀이 없는 경우 1, 뱀이 있는 경우 0이 입력으로 공백을 사이에 두고 주어집니다. 시작 칸과 끝 칸에는 뱀이 주어지지 않는다고 가정해도 좋습니다.

2 ≤ n, m ≤ 100
출력 형식
좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출 가능한 경로가 있으면 1, 없으면 0을 출력합니다.

입출력 예제
예제1
입력:
5 5
1 0 1 1 1
1 0 1 0 1
1 0 1 1 1
1 0 1 0 1
1 1 1 0 1

출력: 
0
예제2
입력:
5 5
1 0 1 1 1
1 0 1 0 1
1 1 1 0 1
1 0 1 1 1
0 1 1 0 1

출력: 
1
"""



n, m = tuple(map(int, input().split()))
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited=[
    [0 for _ in range(m)] for _ in range(n)
]

def checkgo(x,y):
    if (0 <= x <= n-1) and (0 <= y <=m-1) and (grid[x][y] == 1) and visited[x][y] == 0 :
        return True
    else :
        return False


# r d,l
n_x = [0,1]
n_y = [1,0]

def findwway_dfs(x,y):
    for way in range(2):
        next_x = x + n_x[way]
        next_y = y + n_y[way]

        if checkgo(next_x,next_y):
            visited[next_x][next_y] =1
            findwway_dfs(next_x,next_y)    #dfs(x,y) if put info in an x,y wrong to comeback


# x ,y = 0 , 0
visited[0][0] =1
findwway_dfs(0,0)


#
# if visited[n-1][m-1] ==1 : print(1)
# else: print(0)


print(visited[n-1][m-1])



  #    dxs, dys = [0, 1], [1, 0]
 #   for dx, dy in zip(dxs, dys):
