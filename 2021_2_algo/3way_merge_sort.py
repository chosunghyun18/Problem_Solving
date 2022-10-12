# 실습 3등분 합병 정열 4 일 소요       10/16(sat)

def m_sort(A,first,last):
		if first - last >= 0: return
		# 하위로 나기전 미리 스왑으로 시간 단축
		if last-first ==1 :
				if (A[first] > A[last]):
					A[first] , A[last] = A[last] , A[first]
				return

		p1 = ((last - first) // 3)+first
		p2 = ((last - first) // 3) * 2+first

		m_sort(A,first,p1)
		m_sort(A,p1+1,p2+1)
		m_sort(A,p2+2,last)
		merge(A, first,p1, p1 + 1,p2+1)
		merge(A,first,p2+1,p2+2,last)

# same code as. 2 way merge  just change a condtion 
def merge(A,i,j,k,l):
		first = i
		B = []
		while i <= j and k<=l :
				if A[i] <= A[k]:
						B.append(A[i])
						i+=1
				else :
						B.append(A[k])
						k+=1

		for  p in range(i,j+1):
				B.append(A[p])
		for  t in range(k,l+1):
				B.append(A[t])
		for q in range(first,l+1):
				A[q] = B[q-first]


def check(A):
    for i in range(1, len(A)):
        if A[i-1] > A[i]:
            return False
    return A[0]+A[(len(A)//2)]+A[-1]

A = [int(x) for x in input().split()]
m_sort(A, 0, len(A)-1)
print(check(A))
