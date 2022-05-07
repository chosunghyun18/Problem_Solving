

n = int(input())

res1 = 50000
res2 = 50000


i = n // 5
left  = 0

while  i != 0 :
    left = n - (i*5)
    if left % 3 == 0 :
        res1 =  i   + (left//3)
        break ;
    else : i -= 1

if n % 3 == 0:
    res2 = n // 3


if res1 == res2 == 50000:
    print("-1")

else:
    if res1<res2:
        print(res1)
    else: print(res2)

