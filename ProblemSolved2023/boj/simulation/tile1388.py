

import sys

input  = sys.stdin.readline



def solution(data) :
    if not data:
        n, m = map(int, input().split())
        graph = [[]*m for _ in range(n)]
    else :
        m,c = map(int,data[0].split())
        graph = [x for x in data[1:]]

    print((m,c))
    print(graph)