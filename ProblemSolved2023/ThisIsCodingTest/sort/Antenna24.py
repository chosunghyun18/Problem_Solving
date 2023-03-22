import sys
f = sys.stdin.readline

n = int(f())

house = list(map(int,f().split())) # get index of house
house.sort()


n  = house[-1]

distance  = [-1] *(house[-1]+1)


# print(house)

for now in range(1,n+1):
    result = 0
    for hx in house:
        result += abs(now - hx)

    distance[now] = result


ans = int(1e9)
index = 0
for i in range(1,len(distance)) :
    x = distance[i]
    if ans  > x  :
        ans = x
        index = i

print(index)
