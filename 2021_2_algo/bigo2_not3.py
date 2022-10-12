def two_sum(X,Y,t):
    for x in X :
        for y in Y:
            if x+y == t:
                return True
    # if  x+y = t  return True
    return


# 입력 받는 공백 포함 하는 배열
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))


ApB=[]
for x in A:
    for y in B:
        ApB.append(x+y)
print(ApB)


if two_sum(ApB,C,0) == True:
    print("True")
else :
    print("False")



# BiG-O
"""
two_sum 함수의 수행시간은 O(n^2) 이다.
이중 for 문으로 수행시간은 최악의 경우 1+2+3+,,,,+n 이기 때문에     1/2 * (n)(n+1) 이다.

A 와 B 의 모든 원소를 서로 더한 모든 경우를  ApB 배열에 넣었으며 이때의 수행시간도 최악의 경우 two_sum 함수의 시간 시간과 같은 O(n^2) 이다.

O(n^2)인 함수 two_sum 를 n 번 호출한것이 아닌 1번 호출했기 때문에

그렇므로 작성한 프로그램의  BiG-O 는 O(n^2) 이다.  

"""
