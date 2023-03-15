"""
list compregension
"""

# single
arr = [i for i in range(10)]

# 2nd dimension


# [(표현식) for (표현식에서 사용한 변수) in (변수 추출 조건)]



n = 4

arr_2 = [
      [0 for _ in range(n)]
      for _ in range(n) ]


arr_2 = [
        [1 for  x in range(n)] for x in range(n)
]

print(arr_2)


class Cordinate:
    def __init__(self ,x ,y ,number):
        self.x ,self.y ,self.n = x ,y ,number

n = int(input())

given = [
    tuple(map(int, input().split()))
    for _ in range(n)
]


cordinates = [
    Cordinate(x , y , i+1) for i ,(x , y) in enumerate(given)
    ]


#######################################################################
"""
input:
3
1 0 1
0 1 0
0 1 0

출력: 
[(1, 0, 1), (0, 1, 0), (0, 1, 0)]
"""



n = int(input())
given =[ tuple(map(int,input().split()))
        for _ in range(n)]
print(given)



n,r,c  = map(int,input().split())


given =[ tuple(map(int,input().split()))
        for _ in range(n)]
