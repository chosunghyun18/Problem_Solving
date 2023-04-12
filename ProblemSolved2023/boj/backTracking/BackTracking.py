import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
k = int(input())
arr =[]

for _ in range(n):
    arr.append(input().strip())
# print(arr)


case = list(permutations(arr,k))

# print(case)
result =[]
for node in case:
    str =""
    for item in node:
        str+=item
    if int(str) not in result:
        result.append(int(str))





result.sort()
# print(result)
print(len(result))
