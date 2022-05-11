import pandas as pd



def checkleft(x,y,visit):
    if  visit[y][x] == 0:
        return True
    else :
        return False


def calculatesand(n,next_x,next_y,outsand,po,given):
    print("this is x and y:",next_x,next_y)
    print("this is po:",po)
    # po 0 : <-     2:  ->         1 :down     3 : up
    # po 는 이전에서 온 진행 방향 , 좌표 주어진것들
    global dicratio

    q = next_y - 2
    p = next_x - 2

    temp = 0
    print("---")
    print(dicratio[po][2][1])
    print("---")
    for j in range(5):
        for i in range(5):
            if dicratio[po][j][i] != 'a' and dicratio[po][j][i] != 0:   # 비율 숫자
                # 상자 안
                if 0 <= q + j <= n-1 and  0<= p + i <= n-1 :
                        print(type(dicratio[po][j][i]))
                        given[next_y][next_x] += given[next_y][next_x] * dicratio[po][j][i]// 100
                # 상자 밖으로
                else :
                    outsand += given[next_y][next_x] * dicratio[po][j][i] // 100
                temp += given[next_y][next_x] * dicratio[po][j][i] // 100
            else:
                if given[j][i] != 'a' :
                    acord =(j,i)
                else: continue
    # 나머지 a 부분 처리
    if 0 <= acord[0] + q < n and 0 <= acord[1] + p < n:
        given[acord[0]+q][acord[1]+p] += given[next_y][next_y] - temp
    else:  # a 자리도 격자 바깥일 경우 격자 바깥으로 나가는 ans에 더해준다.
        outsand += given[next_y][next_y] - temp

    return  outsand


def solv(n,given,visit):   # main  function to move

    start = n //2
    visit[start][start] = 1

    dirc_x = [-1, 0, 1, 0]
    dirc_y = [0, 1, 0, -1]
    po =0


    current_x = start
    current_y = start

    totalsand = 0
    for j in range(n):
        for i in range(n):
            totalsand += given[j][i]
    print(totalsand)

    outsand = 0

    next_x = current_x + dirc_x[po]
    next_y = current_y + dirc_y[po]


    while True:
        if totalsand == outsand :
            return outsand

        if current_x == 1 and current_y == 0: #종료시점 바로 전
            po -= 1
            next_x = current_x + dirc_x[po % 4]
            next_y = current_y + dirc_y[po % 4]
            outsand += calculatesand(n,next_x, next_y,outsand,po % 4,given)
            return outsand

        else :
            if visit[next_y][next_x] == 0:  # 회전
                outsand += calculatesand(n,next_x,next_y,outsand,po % 4,given)
                current_x , current_y = next_x ,next_y
                visit[current_y][current_x] = 1

                po += 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]



            else :
                po -= 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]
                outsand += calculatesand(n,next_x,next_y,outsand,po%4,given)
                current_x, current_y = next_x, next_y
                visit[current_y][current_x] = 1

                po += 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]


n = int(input())
given =[ tuple(map(int,input().split()))
            for _ in range(n)]
visit = [  [0]*n for _ in range(n)]

dicratio ={
 0: [[0, 0, 2, 0, 0], [0, 10, 7, 1, 0], [5, 'a', 0, 0, 0], [0, 10, 7, 1, 0], [0, 0, 2, 0, 0]],
 1: [[0, 0, 0, 0, 0], [0, 1, 0, 1, 0], [2, 7, 0, 7, 2], [0, 10, 'a', 10, 0], [0, 0, 5, 0, 0]],
 2: [[0, 0, 2, 0, 0], [0, 1, 7, 10, 0], [0, 0, 0, 'a', 5], [0, 1, 7, 10, 0], [0, 0, 2, 0, 0]],
 3:  [[0, 0, 5, 0, 0], [0, 10, 'a', 10, 0], [2, 7, 0, 7, 2], [0, 1, 0, 1, 0], [0, 0, 0, 0, 0]]
}

solv(n,given,visit)








