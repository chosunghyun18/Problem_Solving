import sys

input =sys.stdin.readline


n = int(input())

given = []

for _ in range(n) :
    given.append(input())
ans = given[0]

for item in given:
    for i in range(len(ans)) :
        if item[i] != ans[i]:
            ans =  ans[:i]+"?"+ans[i+1:]
print(ans)








