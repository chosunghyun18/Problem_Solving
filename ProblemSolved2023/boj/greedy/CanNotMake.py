n = int(input())
numbers = list(map(int,input().split()))
numbers.sort()
print(numbers)

maxNum = numbers[-1] + numbers[-2]+1
ans = [0]*maxNum

for i in range(n-1):
    ans[numbers[i]-1] = numbers[i]
    for j in range(i+1,n) :
        check=numbers[j]+numbers[i]

        ans[(check -1)] = check
        # print("ans : ", ans)

print("ans : ",ans)

for i in range(len(ans)) :
    if ans[i] == 0:
        print(i+1)
"""
n = int(input())
data = list(map(int,input().split()))
data.sort()

target = 1
for x in data :
    if target < x : 
        break
    target += x 
print(target)
"""