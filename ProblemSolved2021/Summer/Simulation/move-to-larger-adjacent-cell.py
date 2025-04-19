"""
1 ~ 100 사이의 숫자로 이루어진 n * n 크기의 격자판 정보가 주어집니다. 
이때 특정 위치에서 시작하여, 상하좌우로 인접한 곳에 있는 숫자들 중 현재 위치에 있는 숫자보다
더 큰 위치로 끊임없이 이동합니다. 만약 그러한 위치가 여러개 있는 경우, 상하좌우 방향 순서대로 우선순위를 매겨 가능한 곳 중 우선순위가 더 높은 곳으로 이동합니다. 격자를 벗어나서는 안되며, 더 이상 움직일 수 없을 때까지 반복합니다.

위의 규칙에 따라 방문하게 되는 위치에 적힌 숫자를 순서대로 출력하는 프로그램을 작성해보세요.

입력 형식
첫 번째 줄에는 격자의 크기를 나타내는 n과 시작 위치를 나타내는 r, c 값이 각각 공백을 사이에 두고 주어집니다. r, c는 r행 c열에서 시작함을 의미합니다. (1 ≤ r, c ≤ n)

두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 공백을 사이에 두고 주어집니다.

1 ≤ n ≤ 100
출력 형식
첫 번째 줄에 시작 위치로부터 움직임이 종료될때 까지 방문한 격자에 적혀있는 숫자들을 공백을 사이에 두고 출력합니다.

입출력 예제
예제1
입력:
4 2 2
1 2 2 3
3 5 10 15
3 8 11 2
4 5 4 4

출력: 
5 8 11


"""
n,r,c  = map(int,input().split())


given =[ tuple(map(int,input().split()))
        for _ in range(n)]




def checkcor(x,y):
    if  (0<= x <= n-1 and 0 <= y <= n-1) :return True
    else : return False



num=0
x=r-1
y=c-1
print(given[x][y],end=" ")

#x,y =move(num,x,y)

# 우선순위 맞춰서 확
dirc_x =[-1,1,0,0]
dirc_y =[0,0,-1,1]
po= 0
# make stop
s =0

while True :
    # check next cordinate  to callable
    next_x = x + dirc_x[po]
    next_y = y + dirc_y[po]

    if checkcor(next_x,next_y):
       # 크면
        if given[x][y] < given[next_x][next_y] :

            print(given[next_x][next_y],end=" ")
            x,y = next_x, next_y
            po = 0
            s = 0
        else:
            po += 1
            s += 1
            if s == 4:
                break
    else:
        po += 1
        s += 1
        if s == 4 :
            break
