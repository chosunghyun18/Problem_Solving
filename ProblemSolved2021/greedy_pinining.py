




"""
최소 개수의 못을 꽂는 방법을 찾아라!
막대의 끝을 통과 하더라도 꽂은 것으로 한다.




10
2 3
2 4
3 5
4 6
5 6
6 7
7 9
9 10
10 11
10 12
"""


n = int(input())
a = [tuple(map(int,input().split())) for _ in range(n)]


#종료 값 기준 정렬
a_l= sorted(a,key=lambda x:x[1])
a_l_s = [s for s,_ in a_l]
a_l_l = [l for _,l in a_l]


p = 0
pin=[a_l_l[0]]

# 끝나는 점을 기준으로 앞에 숫자가 적다면 지나감, 크면 새로 꽂는다.
for x in range(n):
    if a_l_s[x] > a_l_l[p] :
        pin.append(a_l_s[x])
        p=x

print(pin)
