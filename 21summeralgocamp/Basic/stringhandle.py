
"""
https://www.codetree.ai/missions

문자열 한 개 입력으로 주어지고 q개의 요청이 주어지면, 각 요청을 수행한 결과를 모두 출력하는 코드를 작성해보세요. 요청의 종류에는 아래의 세 가지가 있습니다.

가장 앞에 있는 문자를 제외한 나머지 문자를 한 칸씩 앞으로 당기고 가장 앞에 있던 문자를 가장 뒤로 옮깁니다.

가장 뒤에 있는 문자를 제외한 나머지 문자를 한 칸씩 뒤로 밀고 가장 뒤에 있던 문자를 가장 앞으로 옮깁니다.

문자열을 좌우로 뒤집습니다.

첫 번째 줄에는 시작 문자열과 요청의 개수 q가 공백을 사이에 두고 주어지고,

두 번째 줄부터는 q개의 줄에 걸쳐 요청이 주어집니다. 잘못된 형태의 요청은 주어지지 않습니다.

1 ≤ 초기 문자열의 길이 (n) ≤ 1,000

1 ≤ q ≤ 1,000

"""
given, num = tuple(input().split())
num= int(num)

def shift_front():
    global given
    given = given[1:] + given[0]
    print(given)


def shift_back():
    global given
    given= given[-1] + given[:-1]
    print(given)


def reverse():
    global given
    given = given[::-1]
    print(given)


for _ in range(num):
    case = int(input())
    if case == 1:
        shift_front()
    elif case == 2:
        shift_back()
    elif case == 3:
        reverse()
