"""
def max_sum(A, left, right):
    # left and right is  index and right given by -1
    if left  == right:    # base line  condition for index is same
        return A[left]
    m = ((left + right) // 2)

    l2m = max_sum(A,left,m)     # split
    # right side of array
    r2m =max_sum(A,m+1,right)

    # m 구성 좌측
    sum,rpastsum= 0 ,0
    for x in range(m,left-1,-1):
        sum += A[x]
        rpastsum = max(sum, rpastsum)

    # m+1   rnrk s
    lpastsum ,sum = 0,0
    for x in range(m + 1, right+1):
        sum += A[x]
        lpastsum = max(sum, lpastsum)

    mm = rpastsum+lpastsum

    return max(l2m,r2m,mm)
    # median array with include m and m+1



#A = [int(x) for x in input().split()]
A=[-1,3, 2, -1, 4, 3, 5, 3, 4, 5, -2 ]
sol = max_sum(A, 0, len(A)-1)
print(sol)




# it can handle missing case of buttom
""" 

def max_sum(A, left, right):
    # left and right is  index and right given by -1
    if left  >= right:    # base line  condition for index is same
        return A[left]

    m = ((left + right) // 2)
    l2m = max_sum(A,left,m)     # split
    # right side of array
    r2m =max_sum(A,m+1,right)

    # m 구성 좌측
    if left-1 < m :
        sum,rpastsum= -1001 ,0
        for x in range(m,left-1,-1):
            sum += A[x]
            rpastsum = max(sum, rpastsum)

    # m+1   rnrk s
    if m+1<right+1:
        sum, lpastsum = -1001,0
        for x in range(m + 1, right+1):
            sum += A[x]
            lpastsum = max(sum, lpastsum)

    mm = rpastsum+lpastsum

    return max(l2m,r2m,mm)
    # median array with include m and m+1


A =[-11,-22,-49]

#A = [int(x) for x in input().split()]

sol = max_sum(A, 0, len(A)-1)
print(sol)

"""
1. 배열의 양 끝 조건을 항상 생각해둔다, 
2. 문제 조건 최소 최대 확인
3. max 함수 이용시 디폴트 min 생각! 
4.우연히 답같은 것일 수도 있음
