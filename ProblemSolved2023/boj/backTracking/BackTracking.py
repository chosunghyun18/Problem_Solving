import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
k = int(input())
arr =[]

for _ in range(n):
    arr.append(input().strip())
print(arr)



for i in permutations([1,2,3,4] ,2 ):
    print(i,end='')





















