




# 재귀 호출은 점화 식을 만드는 포인트를 가지고 있으며 return 을 만나면 함수 호출을 종료 하고 나오게 된다.


def hello(cnt) :

    if cnt == 0:
        return

    print("thi is recursion",cnt)

    cnt -= 1

    hello(cnt)




hello(5)




def fac(n):
    if n ==1 :
        return 1
    return n*fac(n-1)

print(fac(5))

