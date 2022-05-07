n,k = map(int,input().split())

am = []
for _ in range(n):
    am.append(int(input()))

# 1  단위  필수 보장 가장 큰거부터 check -> 작은 단위가 큰단위로 보장아아앙

result = 0
for  i in range(len(am)-1,-1,-1):
    if  k % am[i] == k :
        continue
    else :
        result += k // am[i]

        k = k % am[i]
    if k == 0 :
        break;



print(result)

# reversed  ->
