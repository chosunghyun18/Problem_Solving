import sys
input = sys.stdin.readline
given = input()

x = int(given[1])
y = int(ord(given[0])) - int(ord('a')) + 1

move = [(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]

c = 0
for node in move:
    nx = x+node[0]
    ny = y + node[1]
    if nx <= 0 or ny <= 0 or nx >= 9 or ny >= 9 :
        continue
    c += 1
print(c)

"""
start  = (x,y)
print(start)

graph = [[0]*9 for _ in range(9)]
print(graph)

cango = [(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]
n = 8
for point in cango:
    nx = point[0] + x
    ny = point[1] + y
    if nx < 0 or ny < 0 or nx > n or ny > n :
        continue
    else :
        graph[nx][ny] = 1

print(graph)

count = 0
for i in range(1,8):
    for j in range(1,8):
        if  graph[i][j] ==1  :
             count+=1
print(count)
"""