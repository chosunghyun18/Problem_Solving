from itertools import combinations
n ,m = map(int,input().split())
# 다다 익선,
# get 2 array
chick , house = [] , []

for y in range(n):
    data = list(map(int,input().split()))
    for x in range(n):
        if data[x] == 1 :
            house.append((y,x))
        if data[x] == 2 :
            chick.append((y, x))

# combination  list number of shop C m    치킨 집
check = list(combinations(chick,m))

def cal_dis(candiate):
    result = 0
    for hx,hy in house :
        temp = int(1e9)
        for cx,cy in candiate :
            temp = min(temp,abs(hx -cx)+abs(hy-cy))
        result += temp
    return result

result = int(1e9)

for candidate in check :
    result = min(result,cal_dis(candidate))

print(result)

