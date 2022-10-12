def find_max_sum(A):
	S = [0] * len(A)
	S[0] = A[0]
	for i in range(1, n):
		S[i] = max(S[i-1]+A[i], A[i])
	return max(S)

n=int(input())
A=[int(x) for x in input().split()]
print(find_max_sum(A))

# time Big_O
#O(N)
