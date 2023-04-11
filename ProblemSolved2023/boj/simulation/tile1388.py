

import sys

input  = sys.stdin.readline

def bfs(graph,n,m,i,j) :
    if graph[i][j] == "-" :
        while j < m :
            if graph[i][j] == "|" or graph[i][j] == "." :
                return graph
            graph[i][j] = '.'
            j+=1
        # print(graph)
        return graph
    else :
        while i < n :
            if graph[i][j] == "-" or graph[i][j] == ".":
                return graph
            graph[i][j] = '.'
            i += 1
        print(graph)
        return graph

def solution(data) :
    if not data:
        n, m = map(int, input().split())
        graph = [input().replace(""," ").split() for _ in range(n)]
    else :
        n,m = map(int,data[0].split())
        graph = [x.replace(""," ").split() for x  in data[1:]]

    print(n,m)
    print(graph)
    ans = 0
    for  i in range(n):
        for j in range(m):
            if graph[i][j] != '.' :
                ans+=1
                graph = bfs(graph,n,m,i,j)


    print(ans)


solution(False)