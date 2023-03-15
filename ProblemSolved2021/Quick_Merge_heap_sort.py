import random,timeit

## qs
def quick_sort(A,first,last):
    if first >= last : return A[last]
    global Qc, Qs
    left,right = first+1 , last
    p = A[first]
    while left <= right:
        while left <= last and A[left] <p :
            left+=1
            Qc += 1
        while right > first and A[right] > p :
            right -= 1
            Qc += 1
        if left <= right  : # Swap  A[left ] and A[right]
            A[left]  , A[right] = A[right]  , A[left]
            left += 1
            right -=1
            Qs += 1

        # palce pivaot at the right place
    A[first] , A[right] = A[right], A[first]
    Qs+=1
    quick_sort(A,first,right-1)
    quick_sort(A,left,last)
    #quick_sort(A,right+1, last)    # same index number which is havit


#insertion_sort
def insertion_sort(A,n):
    for i in range(1,n) :
        j =i-1
        while j >= 0 and A[j] > A[j+1] :
            A[j], A[j+1] =A[j+1] ,A[j]
            j = j-1
    return A
#quick sort with undercondition of insertion function
def i_quick_sort(A,first,last,k):
    if first >= last :
        return A[last]

    if last - first <= k:
        A[first:last + 1] = insertion_sort(A[first:last + 1], len(A[first:last + 1]))

    left,right = first+1 , last
    p = A[first]
    while left <= right:
        while left <= last and A[left] <p :
            left+=1
        while right > first and A[right] > p :
            right -= 1
        if left <= right  : # Swap  A[left ] and A[right]
            A[left]  , A[right] = A[right]  , A[left]
            left += 1
            right -=1
        # palce pivaot at the right place
    A[first] , A[right] = A[right], A[first]
    i_quick_sort(A,first,right-1,k)
    i_quick_sort(A,left,last,k)


## ms
def merge_sort(A,first,last):
    if first >= last : return
    merge_sort(A,first,(first+last)//2)
    merge_sort(A,((first+last)//2)+1,last)
    merge_two_sorted_lists(A,first,last)

def merge_two_sorted_lists(A,first,last):
    global Mc,Ms
    m = (first+ last) // 2
    i,j = first , m+1
    B = []
    while i <= m and j<=last :
        if A[i] <= A[j]:
            B.append(A[i])
            i+=1
        else :
            B.append(A[j])
            j+=1
        Mc += 1 #  비교


    for  k in range(i,m+1):
        B.append(A[k])
    for  k in range(j,last+1):
        B.append(A[k])
    for i in range(first,last+1):
        A[i] = B[i-first]

    Ms += ( (last+1) - first)*2   # 이동 a -> b -> a

#merge sort with undercondition of insertion function
def i_merge_sort(A,first,last,k):
    if first >= last : return
    # unde condtion k<40
    if last - first <= k:
        A[first:last+1] = insertion_sort(A[first:last+1],len(A[first:last+1]))
    else:
    # 분할
        i_merge_sort(A,first,(first+last)//2,k)
        i_merge_sort(A,((first+last)//2)+1,last,k)

        # 병
        i_merge_two_sorted_lists(A,first,last)

def i_merge_two_sorted_lists(A,first,last):
    m = (first+ last) // 2
    i,j = first , m+1
    B = []
    while i <= m and j<=last :
        if A[i] <= A[j]:
            B.append(A[i])
            i+=1
        else :
            B.append(A[j])
            j+=1
    for  k in range(i,m+1):
        B.append(A[k])
    for  k in range(j,last+1):
        B.append(A[k])
    for i in range(first,last+1):
        A[i] = B[i-first]

## hs
def heap_sort(C):
    global Hs, Hc
    n = len(C)

    for k in range(n // 2, -1, -1):
        heapify_down(C, k, n)
    for k in range(len(C)-1,-1,-1):
        C[0] , C[k] = C[k] ,C[0]
        Hs += 1
        n = n-1
        heapify_down(C,0,n)

def heapify_down(C, k, n):
    global Hs, Hc
    while 2 * k + 1 < n:
        L, R = 2 * k + 1, 2 * k + 2
        Hc +=2 # move
        if L < n and C[L] > C[k]:
            m = L
        else:
            m = k

        if R < n and C[R] > C[m]:
            m = R

        if m != k:
            C[k], C[m] = C[m], C[k]
            Hs+= 2 # swap
            k = m

        else:
            break


#### 하단부 코드 동일

def check_sorted(A):
    for i in range(n-1):
        if A[i] > A[i+1]:return False
    return True



#Global 변수로 선언
#Qc : 리스트의 두수를 비교한 횟수 저장
#Qs: 두수를 교환한 횟수 저장
#mc,msn는 merge sort 에서 비교, 교환(또는 이동 ) 횟수 저장

# this kind of valriable will be using for global variable
# Hc, Hs는 heap sort에서 비교, 교환(또는 이동) 횟수 저장
Qc,Qs = 0,0
Mc,Ms = 0,0
Hc,Hs = 0,0

n = int(input())
random.seed()
A = []
for i in range(n) :
    A.append(random.randint(-1000,1000))
B = A[:]
C = A[:]


print("")
print("Quick sort:")
print("time =",timeit.timeit("quick_sort(A,0,n-1)",globals=globals(),number=1))
print("  comparisoon = {:10d},swaps= {:10d}\n".format(Qc,Qs))


print("Merge sort:")
print("time =",timeit.timeit("merge_sort(B,0,n-1)",globals=globals(),number=1))
print("  comparisoon = {:10d},swaps= {:10d}\n".format(Mc,Ms))

print("Heap sort:")
print("time =",timeit.timeit("heap_sort(C)",globals=globals(),number=1))
print("  comparisoon = {:10d},swaps= {:10d}\n".format(Hc,Hs))


#  진짜 정렬되었는지 check 한다. 정렬이 되지 않았더며 fail
# check  sorted if there an error ?
assert(check_sorted(A))
assert(check_sorted(B))
assert(check_sorted(C))


#i_quick_sort(A,0,n-1, 10)
#i_merge_sort(A,first,last,k)
