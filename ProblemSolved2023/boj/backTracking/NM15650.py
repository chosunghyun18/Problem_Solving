import sys
input = sys.stdin.readline


n,m = map(int,input().split())
result =[]
visited= [False]*(n+1)
def dfs(n,m) :
    if m == len(result) :
        for item in result:
            print(item,end=' ')
        print()

    for i in range(1,n+1):
        if len(result) !=0 :
            if result[-1] > i :
                continue
        if not visited[i] :
            visited[i] = True
            result.append(i)
            dfs(n,m)
            result.pop()
            visited[i] = False


dfs(n,m)