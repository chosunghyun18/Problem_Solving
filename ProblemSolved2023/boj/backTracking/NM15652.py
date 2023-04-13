import sys

input = sys.stdin.readline
n ,m  = map(int,input().split())

outre = []
allre = []

def dfs(n,m) :
    if len(outre) == m :
        for item in outre :
            print(item,end=' ')
        print()
        return

    for i in range(1,n+1) :
        if len(outre) != 0:
            if outre[-1] > i :
                continue
        outre.append(i)
        dfs(n,m)
        outre.pop()



dfs(n, m)