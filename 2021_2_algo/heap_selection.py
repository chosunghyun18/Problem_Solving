import heapq

def solve(A, k): # return k-th smallest key, 1 <= k <= n
	# if k is small using min heap 
	if k < ((len(A)+1)/2):
		for _ in range(k-1):
			heapq.heappop(A)
		answ = heapq.heappop(A)
		return answ
	
	#if k is big using max heap
	else:
		k= len(A)+1 - k
		A = maxheap(A)
		
		for _ in range(k-1):
			heappop(A)
		answ=heappop(A)
		return answ

	
def heapify_down(A,k,n):
	while 2*k +1 <n:
		L,R = 2*k + 1 ,2*k + 2
		if L<n and A[L] > A[k] :
			m = L
		else: m = k
			
		if R < n and A[R] > A[m]:
			m = R
			
		if m != k :
			A[k] , A[m] = A[m] ,A[k]
			k = m
			
		else:	
			break	

	
def maxheap(A):
		n = len(A)
		for k in range(n//2,-1,-1):
			heapify_down(A,k,n)
		
		return A
	
	
def heappop(A):
	maxv = A[0]
	A[0],A[-1] = A[-1],A[0]
	A.pop()
	heapify_down(A,0,len(A))
	return maxv




k = int(input())
A = [int(x) for x in input().split()]
heapq.heapify(A) # A is now a min-heap
print(solve(A, k))




"""
k 번째로 작은수를 찾는 문제의 알고리즘을 작성하는데 있어 단순 하게 min heap 하나 만을 이용 할 수도 있지만
max heap 을 같이 사용 함으로 k 가 배열의 크기와 가깝게 커지거나,k 가 작을 때 효율이 좋은 알고리즘을 짜고자 했다.

단 순하게 min_heap 만을 사용 하는 알고리즘을 사용시  입력값 k 가 배열의 크기 n 일때 배열을 작은 수 부터 뽑는다면 O(nlogn) 이지만 
max 힙으로 접근을 하면 heapify_down() 의 단일 수행시간인 log(n)으로 처리가 가능하다.

즉 평균 O(nlogn)인 알고리즘에서 O( (n/2) * logn ) 으로 바뀐다.


solve 함수의 시간 복잡도 분석 : 

heapq.heappop(A) A 는 배열

상위에 있는 노드를 반환 하고 하단에 있는 노드를 올린후 heapify 을  수행
즉 배열의 0 번째  인덱스를 반환 삭제 한후 힙으로 재배열을 하는 코드이다.

heapify 연산의 시간 복잡도: 두 자식들 중 더 작은 쪽을 찾아 교환하는 연산을 하며 heap의 tree 에서  한 래밸 내려온다.
tree의 높이를 h 라 하면 시간 복잡도는 O(h)이다.

여기서 h는 , 노드의 수 n 즉 배열 A 의 길이가 주어질때 log(n) 이 된다.

solve 함수의 수행시간은 최악의 경우 k = n/2 인경우 (찾고자 하는 값이 중앙 값일때)  :   O(n/2 * log(n))  이다.

다른 3 가지 알고리즘과 비교시:

장점 : 찾고자 하는 수 k 가 n 개의 숫자를 갖는 배열에서 최솟 값과 최대 값에 가까울수록 수행시간이 (logn) 에 가까워진다. (단, 주어진 배열이 heap일 경우)






--------------------------------------------------------------------------------------
change code by o(n) to klogk

using new min heap

minheap > where is next min value in a tree?

minheap = min(nextnode1,sunof root,,,,,)



"""



