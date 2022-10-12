"""

수란 자기 자신을 제외한 모든 양의 약수들을 더했을 때 자기 자신이 되는 수 입니다.

예를 들어 6 = 1 + 2 + 3 이므로 6은 완전수 입니다.

주어지는 start에서 end 이내에 있는 숫자들 중 완전수가 몇 개인지 출력하는 코드를 작성해보세요.

입력:
3 30

출력:
2
"""
start , end = input().split(' ')

tmp = []
sumt = 0
count = 0
for r in range(int(start),int(end)+1):
    # check complete num
    for x in range(1,r):
        if r%x == 0 :
            sumt = sumt+x

    if sumt == r:
        count +=1
    sumt = 0

print(count)
