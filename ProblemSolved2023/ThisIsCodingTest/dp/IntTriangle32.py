n = int(input())
arr = []
for _ in range(n) :
    arr.append(list(map(int,input().split())))

print(arr)

for i in range(1,n):
    m = len(arr[i])
    for j in range(m) :
        # left slide edge
        if j == 0 :
            curr=arr[i][0]
            arr[i][0] = curr + arr[i-1][0]
        # right slide edge
        elif j == m :
            curr = arr[i][m]
            arr[i][0] = curr + arr[i - 1][len(arr[i-1])]
        else :
            curr = arr[i][m]
            arr[i][0] = curr + max( arr[i - 1][j-1] ,arr[i - 1][j+1])


print(max(arr[n]))


