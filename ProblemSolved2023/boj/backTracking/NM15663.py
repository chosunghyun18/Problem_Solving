import sys
input = sys.stdin.readline

n,m = map(int,input().split())

given = list(map(int,input().split()))
given.sort()


visited = [False] * (n)
results = []
result = []

def dfs(n,m,result) :
    if len(result) == m :
        tmp =""
        for item in result :
            tmp +=str(item)
        results.append(int(tmp))
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result += str(given[i])
            dfs(n,m,result)
            visited[i] = False
            result.pop()

dfs(n,m,result)

resultsSet = list(set(results))
resultsSet.sort()
for item in resultsSet:
    number = str(item)
    print(' '.join(number))


