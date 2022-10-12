



"""
1 = 장에물
0 = 길 

시작점에서 끝점 가느곳 탐색

마지막 최종경로 trace -> 다녀온길 지우기! 



if ifelse 구문 조심






11111111111
10100000101
10101110101
10101010101
10111010101
10000000101
10111011101
10001000001
10101011111
10100000001
11111111111


11
3 3 9 9
11111111111
10100000101
10101110101
10101010101
10111010101
10001000101
10111011101
10001010001
10101011101
10100000001
11111111111
"""




def printm() :
    for row in M:
        for c in row:
            if c == '1':
                print('#', end="")
            elif c == '0':
                print('M', end="")
            else:
                print(c, end="")
        print()
    print()

result =False

def find_way_from_maze(r, c):
    global result
    if r == ex and c == ey:
        result =True
        return True

    if (0 <= r <= n - 1 and 0 <= c+1 <= n - 1) and not visited[r][c+1] and M[r][c+1] == '0':
        M[r][c+1] = trace
        visited[r][c+1] = True
        right = find_way_from_maze(r, c+1)
        if right :
            return right
        else :
            M[r][c+1] = '0'
            printm()

    if (0 <= r+1 <= n - 1 and 0 <= c <= n - 1) and not visited[r+1][c] and M[r+1][c] == '0':
        M[r+1][c] = trace
        visited[r+1][c] = True
        down = find_way_from_maze(r+1, c )
        if down:
            return down
        else:
            M[r+1][c] = '0'
            printm()

    if (0 <= r <= n - 1 and 0 <= c - 1 <= n - 1) and not visited[r][c - 1] and M[r][c -1] == '0':
        M[r][c - 1] = trace
        visited[r][c-1] = True
        left = find_way_from_maze(r, c - 1)
        if left:
            return left
        else:
            M[r][c - 1] = '0'
            printm()

    if (0 <= r-1 <= n - 1 and 0 <= c  <= n - 1) and not visited[r-1][c] and M[r-1][c] == '0':
        M[r-1][c] = trace
        visited[r-1][c] = True
        up = find_way_from_maze(r-1, c)
        if up:
            return up
        else:
            M[r-1][c] = '0'
            printm()
    # no way

    M[r][c] = '0'
    return False



trace = '\u00B7'
n = 11
sx, sy, ex, ey=3, 3, 9,9



# n = int(input())
# sx, sy, ex, ey = (int(x) for x in input().split())
M = []

# row 0 and n+1 are all 1's
# col 0 and n+1 are all 1's
for i in range(n):
    M.append([c for c in input()])

visited = [[False for _ in range(n)] for _ in range(n)] # 미방문,

visited[sx][sy] = True

M[sx][sy] = 's'

find_way_from_maze(sx, sy)
success = result
success = True
M[ex][ey] = 'e'




if success:
    for row in M:
        for c in row:
            if c == '1':
                print('#', end="")
            elif c == '0':
                print('M', end="")
            else:
                print(c, end="")
        print()
    print()
else:
    print("NO WAY!")
