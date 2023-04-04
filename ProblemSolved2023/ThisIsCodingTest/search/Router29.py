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



def binary(arr,start,end) :
    mid = end - start // 2
    if visited[mid] == False :
        visited[mid] = True
        return
    else :
        #condition of chek right
        mid
        return binary(arr,mid+1,end)



n,c = list(map(int,input().split()))
array = []
for _ in range(n):
    array.append(int(input()))
array.sort()

start =1
end = array[-1] - array[0]
result = 0

while (start<=end) :
    mid = end+start // 2  # 가장 인접한 두 공유기의 사이의 거리를 의미
    value = array[0]
    count = 1
    # install router
    for i in range(1,n) :
        if array[i] >= value + mid :
            value = array[i]
            count += 1
        if count >= c :  # 추가적인 공유기 설치가 가능하면 거리를 증가 시킨다.
            start = mid + 1
            result = mid
        else :
            end =  mid -1

print(result)












