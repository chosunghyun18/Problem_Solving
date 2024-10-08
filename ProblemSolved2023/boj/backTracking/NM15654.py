import sys

input = sys.stdin.readline
n,m = map(int,input().split())

arr = list(map(int,input().split()))
arr.sort()


visited = [False] * n
result = []

def dfs(n,m):
    if len(result) == m :
        for item  in result:
            print(item,end=" ")
        print()

    for i in range(n):
        if visited[i] == True:
            continue
        if len(result) != 0 :
            if result[-1] > arr[i]:
                continue
        visited[i] = True
        result.append(arr[i])
        dfs(n,m)
        visited[i] = False
        result.pop()



dfs(n, m)