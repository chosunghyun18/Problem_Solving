"""

by.Q  :  https://www.codetree.ai/missions

향후 n년 간의 자동차 가격 정보가 미리 주어졌을 때, 자동차를 단 한 번 사서 되팔 때의 이익을 최대화하고자 합니다. 
낼 수 있는 최대 이익을 출력하는 프로그램을 작성해보세요. 단, 자동차를 사기 전에는 팔 수 없습니다.

첫 번째 줄에는 n이 주어지고, 두 번째 줄에는 n년 간 각 해의 자동차 가격이 공백을 사이에 두고 주어집니다.

자동차 가격은 00 ~ 2^{31} - 12 
31
 −1 사이의 범위를 갖습니다.

1 ≤ n ≤ 1,000

입력:
5
9 10 2 3 6

출력:
4
"""
n = int(input())
prices = list(map(int, input().split()))

i = 0
j = 1
maxsell = 0
while j < len(prices) and i < len(prices):
    # 가격이 같거나 하강시
    if prices[i] >= prices[j]:
        i = j
        j = j + 1

    else:  # 가격이 상승하면
        maxsell = max(maxsell, (prices[j] - prices[i]))
        j = j + 1



print(maxsell)
