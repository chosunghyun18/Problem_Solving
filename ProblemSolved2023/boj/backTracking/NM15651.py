import sys
input = sys.stdin.readline
n, m =map(int,input().split())



result =[]
def dfs(n,m) :
    if len(result) == m :
        for item in result:
            print(item,end=' ')
        print()
        return

    for i in range(1,n+1):
        result.append(i)
        dfs(n,m)
        result.pop()


dfs(n,m)