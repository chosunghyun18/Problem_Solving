

"""
패널티 점수 : (폭-해당 줄의 글자수 - 단어수)**3


Ape ate apple.
단어수 : 12
공백수 : 2
폭 16일시
16-14 = 2 
2**3 = 8 점





"""






# import pandas as pd

# 왼쪽 맞춤 문제 ~ 행렬곱셈과 같은 방식
#given Data

w= int(input())
words = input().split()
n=len(words)

# penalty를 계산 하여 저장할 dp 테이블
dp = [[0]*n for _ in range(n)]
# dpo=pd.DataFrame(dp)
# print(dpo)

#초기 값 설정 i부터 i 번째는 공백이 없는 단어 하난의 패널티 값을 저장한다
for x in range(n):
				dp[x][x]= (w-len(words[x]))**3

# dpo=pd.DataFrame(dp)
# print(dpo)

for j in range(1,n):
				for i in range(j-1,-1,-1):
								dp[i][j] = 9999999
								for k in range(i,j+1):
												if k == j :
														# i 부터 j 까지 문자열을 합친것의 패널티
														sumlen = len("".join(words[i:j + 1]))
														# w-글자수-(공백수)
														ps = w-sumlen-(j - i)
														
														if ps >= 0: #ps < 0 -> 폭을 벗어 난것으로 간주
														    p_t = ps ** 3
												else:
														p_t = dp[i][k]+dp[k + 1][j]
												if p_t < dp[i][j]:
																dp[i][j] = p_t

# dpo=pd.DataFrame(dp)
# print(dpo)

print(dp[0][n- 1])

"""
dp[i][j] =words 의 단어들에서 i 부터 j 까지의 단어들의 최소 페널티
      각묶음의 최소 = 전채의 최소  
       min(i,,,,k)+min(k+1,,,j)

점화식:   (i<=k< j)
dp[i][j] = min penalty (dp[i][k]+dp[k + 1][j])


dp테이블을 체우는 순서 -> 행렬의 중앙에서 위로, 좌측에서 우측으로 1,2,3,4,5,,,,,,,n
수행시간 :상 삼각 행렬을 채우는데 걸리는 시간 = O(n(n-1)/2) = O(N^2)
"""
