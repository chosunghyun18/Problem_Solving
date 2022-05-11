import pandas as pd



def checkleft(x,y,visit):
    if  visit[y][x] == 0:
        return True
    else :
        return False


def calculatesand(next_x,next_y,totalsand,outsand,po):
    print("this is x and y:",next_x,next_y)
    print("this is po:",po)
    # po 0 : <-     2:  ->         1 :down     3 : up



    return totalsand , outsand

def solv(n,given,visit):

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
            totalsand, outsand = calculatesand(next_x, next_y, totalsand, outsand,po % 4)
            return outsand

        else :
            if visit[next_y][next_x] == 0:  # 회전
                totalsand, outsand = calculatesand(next_x,next_y, totalsand, outsand,po % 4)
                current_x , current_y = next_x ,next_y
                visit[current_y][current_x] = 1

                po += 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]



            else :
                po -= 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]
                totalsand, outsand = calculatesand(next_x,next_y, totalsand, outsand,po%4)

                current_x, current_y = next_x, next_y
                visit[current_y][current_x] = 1


                po += 1
                next_x = current_x + dirc_x[po%4]
                next_y = current_y + dirc_y[po%4]


n = int(input())
given =[ tuple(map(int,input().split()))
            for _ in range(n)]
visit = [  [0]*n for _ in range(n)]


solv(n,given,visit)








