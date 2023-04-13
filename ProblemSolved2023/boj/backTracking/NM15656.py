import sys

input = sys.stdin.readline
n,m = map(int,input().split())

arr = list(map(int,input().split()))
arr.sort()

result = []
def dfs(n,m):
    if len(result) == m :
        for item  in result:
            print(item,end=" ")
        print()
        return

    for node in arr :
        result.append(node)
        dfs(n,m)
        result.pop()






dfs(n, m)