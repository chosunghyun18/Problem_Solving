"""
원점으로부터의 거리

2차 평면 위에 N개의 점이 주어졌을 때, 
원점에서 가까운 점부터 순서대로 번호를 출력하는 프로그램을 작성해보세요. 
거리가 같은 점이 여러 개인 경우, 번호가 작은 점 부터 출력합니다.

단, 여기서의 거리란 멘하턴 거리를 의미합니다. 두 점 (x1, y1), (x2, y2) 사이의 멘하턴 거리는 |x1 - x2| + |y1 - y2|로 정의됩니다.



출력 형식
N개의 줄에 걸쳐 원점에서 가까운 점 부터 순서대로 한 줄에 하나씩 각 점의 번호를 출력합니다. 
거리가 같은 점이 여러 개인 경우, 번호가 작은 점부터 먼저 출력합니다.
입력:
2
1 5
-3 2

출력: 
2
1

"""



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



cordinates.sort(key=lambda x: ( abs(x.x)+abs(x.y) , x.n))



for dot in cordinates:
    print(dot.n)
