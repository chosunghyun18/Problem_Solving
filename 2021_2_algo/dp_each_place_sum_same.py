
"""
자리값 합이 같은 경우의 수를 출력 하는 알고리즘을 구현한다. 

L(4,2)
= > 1100,1001,2000,1010 , 4가지
"""

#L >= 1
#S >= 1

"""
경우의 수를 생각해 보면, 자리가 1 자리 일때 합은 10이상이 나올 수가 없다.
즉 s(sum) ,l(자리수 length) 일시

자리수 가 1 일때 , j=(0~8)까지 /합이 1 부터 9  / 오는 경우의 수는 모두 1 이다.
dpt[1][j] = 1

모든 자리의 합이 1인 경우 자리수(L)와 상관 없이 1가지이다.  00001 불가 이기때문,
dpt[L][0] = 1

전화식은 해를 분석한 이유로 ,s 가 9 보다 거나 작은 경우로 나눠서 생각을 해본다.
s 총합이 < 9 시    dp[i][j] = sum(dp[i-1][j],dp[i-1][j-1],dp[i-1][j-2],,,,,dp[i-1][1]) 이며 이는 다음과 같다.
dpt[i][j] = dpt[i][j-1]+dpt[i-1][j]   , j-1 단계에서 정보를 가져와 j 인 경우를 생각 하는것과 같다. (dp 테이블을 채우면 알수있다.)


s(총) > 9 일합시.  2자리수 10 을 만드는 경우 1~9 를 반대로짝지으면 9 가지, 11을 만드는 경우 2~9 를 전과 같은 방식으로 만든다.
아를 통해 알수 있는 점화 식은
s > 9
dpt[i][j] = sum(dp[i-1][j],dp[i-1][j-1],dp[i-1][j-2],,,,,dp[i-1][j-10])
-> (정리하)
dpt[i][j] = dpt[i][j-1]+dpt[i-1][j] -(dpt[i-1][j-10])

s < 9
dpt[i][j] = dpt[i][j-1]+dpt[i-1][j]
면
와 같이 새운다.

수행시간은  2차원 L*s 행렬을 모두 채워야 함으로
O(L*S) 이다.   
최악의 경우 L=S=n 일시
O(N*2) 이다.

"""


def solve(L, S):
	# code here
	if L ==1 or S ==1 :
		return 1

	S = S
	L = L

	dpt = [  # input int intterval start in 1
		[ 0 for x in range(S)]
		for _ in range(L)]

	if S > 9 :
		for j in range(9):
			dpt[0][j] = 1
		for i in range(L):
			dpt[i][0] = 1

		for i in range(1,L):
			for j in range(1,10):
				dpt[i][j] = dpt[i][j-1]+dpt[i-1][j]


		for i in range(1,L):
			for j in range(10,S):
				dpt[i][j] = dpt[i][j-1]+dpt[i-1][j] -(dpt[i-1][j-10])


	else :
		for i in range(S):
			dpt[0][i] = 1
		for j in range(L):
			dpt[j][0] = 1

		for i in range(1,L):
			for j in range(S):
				dpt[i][j] = dpt[i][j-1]+dpt[i-1][j]

	return dpt[L-1][S-1]

L, S = [int(x) for x in input().split()]


print(solve(L, S)%2147483647)
