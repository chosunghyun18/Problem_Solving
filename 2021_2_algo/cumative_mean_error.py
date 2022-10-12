# 데이 터 분할 서로 다른 5 개 2 그룹 나누는 경우
# [1_2_3_4_5]   = 자리수 4 개 중에 하나를 고르는 경우의 수
# 데이 터 분할 서로 다른 n 개 b 개의 그룹 나누는 경우
# 자리수 n 개중 b-1 을  고른다.
# 조합이니 파스칼의 삼각형 이용
# 첫 줄에는 b 외 n  is  given
# newx n 만큼 숫자 given
#  [a1,a2,a3,,,,an] 일시
#   a1~ak  의 평균, mk = (1/k) *(mk-1 * (k-1) + ak) 를 만족한다
#   a1~ak 의 오차의 합(Sum of squared Error)  Sk = Sk-1 + U
#           U = (ak)^2 - ( k*(mk)^2) + (k-1)*(mk-1)^2  이다.
# 그룹 수 n-1 에 가까울수록 오차가 작다.

import pandas as pd

g = 2
L = [4,2,3,6,5,6,12,16]
n =len(L)


# grouping table

dpm = [  # DP table of mean
	[0 for _ in range(len(L))]
	for _ in range(len(L) + 1)]
for x in range(n):
	dpm[0][x] = L[x]
# for x in range(n):
#     dpm[x + 1][x] = L[x]       #1 개일때 기본 평균
dpo = pd.DataFrame(dpm)

print(dpo)
print("-----------")
# calculate each mean in camulative
for i in range(1, len(L) + 1):
	m_t_1 = dpm[0][i-1]  # 평균 초기값 세팅    t- 1 시점
	t = 1  # t- 1 시점
	for j in range(i, len(L)):
		# t-1 의 값들 > t 로 갱신 
		t = t + 1

		new = dpm[0][j]

		m_t = ((m_t_1 * (t - 1)) + dpm[0][j]) * (1 / t)

		a = ((dpm[0][j]) * (dpm[0][j]) - (t * m_t * m_t) + ((t - 1) * m_t_1 * m_t_1))

		dpm[i][j] = dpm[i][j - 1] + a
		dpm[i][j] = round(dpm[i][j], 3)
		m_t_1 = m_t



# mean >>   m3 = [(m2 * 2 ) + a3] *(1/3)
dpo = pd.DataFrame(dpm)
print(dpo)
