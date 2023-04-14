
from itertools import product

"""
point 1 . product 사용
point 2 . data 의 size 의 따른 완탐 가능성 : dfs 를 이용한 벡트래킹이 필요없음 
point 3. 문제 해결 능력 , -> 간단한 변수 설정과 조건문으로 햐결

"""


# Best Code

def solution(users, emoticons):
    register_user_count = 0
    max_price = 0

    discounts = product([10, 20, 30, 40], repeat=len(emoticons))
    # 모든 할인율 중복 조합
    for discount in discounts:
        # 각 조합마다 산 유저 수 / 최대 판매 금액
        user_count = 0
        sum_price = 0

        # 각 유저마다
        for user in users:
            # 구매 비용
            paid = 0

            # 구매 비용 계산
            # 이모티콘마다
            for i in range(len(emoticons)):
                # 할인율이 유저 기준보다 높거나 같다면
                if (discount[i] >= user[0]):
                    # 구매 비용에 추가
                    rate = (100 - discount[i])
                    price100 = emoticons[i] * rate
                    # print(price100 // 100)
                    paid += price100 // 100

            # 본인이 낸 돈이 기준보다 높다면
            if (paid >= user[1]):
                # 이모티콘 플러스 등록
                user_count += 1
            # 아니라면
            else:
                # 총 판매금액에 추가
                sum_price += paid

        if (register_user_count < user_count):
            register_user_count = user_count
            max_price = sum_price
        elif (register_user_count == user_count):
            if (max_price < sum_price):
                max_price = sum_price

    return [register_user_count, max_price]






