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

    for i in range(n) :
        if len(result) != 0:
            if result[-1] > arr[i] :
                continue
        result.append(arr[i])
        dfs(n,m)
        result.pop()






dfs(n, m)