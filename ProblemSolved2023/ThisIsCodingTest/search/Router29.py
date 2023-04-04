# c = number of router : for max
n ,c = map(int ,input().split())

arr =[]
for _ in range(n):
    arr.append(int(input()))

print(arr)

# if not sorted make sort
arr.sort()

visited = [False] * n

start = 0
end = n
mid = 0


def binary(arr,start,end) :
    mid = end - start // 2
    if visited[mid] == False :
        visited[mid] = True
        return
    else :
        #condition of chek right
        mid
        return binary(arr,mid+1,end)



