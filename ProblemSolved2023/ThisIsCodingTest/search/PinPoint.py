### pinPoint find mid value
# find fixed point
n = 5
ex = [-15,-4,2,8,13]
arr = ex[:]
visited = [False]*n

# n = int(input())
# arr = list(map(int,input().split()))

mid = n // 2
start = 0
end = n

def search(start,mid,end,arr) :
    print(visited)
    mid = start - end // 2
    if (visited[mid] == False):
        visited[mid] = True
        if ex[mid] < mid :  #search in right side
            search(mid,end- mid // 2,end,arr)
        elif ex[mid] == mid :
            print(mid)
            return
        else :
            search(start, mid - start // 2, mid, arr)



def search(arr,start,end):
    if start > end :
        return None
    mid = start +end // 2
    if arr[mid] ==  mid :
        return mid
    elif arr[mid] > mid:
        return search(arr,start,mid-1)
    else:return search(arr,start,mid+1)



search(start,mid,end,ex)