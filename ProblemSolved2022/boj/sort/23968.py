
####### boj 설정 pypy 3


import sys
# data = list(map(int, sys.stdin.readline().split()))

n,count = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))
# array = list(map(int,input().split()))



def solv(count) :
    for j in range(n-1):
        for i in range(0,n - (j+1) ):
            if array[i] > array[i+1]:
                count -= 1
                array[i] ,array[i+1]  = array[i+1],array[i]
                if count == 0 :
                    return print( array[i] ,array[i+1])
    return print(-1)


solv(count)
















