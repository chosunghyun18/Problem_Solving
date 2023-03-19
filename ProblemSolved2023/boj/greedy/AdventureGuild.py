"""
여행을 떠날 수 있는 그룹 수의 최솟 값을 구하시오
"""

member = int(input())
total = member
status = list(map(int,input().split()))
status.sort()
group,check,i = 0 , 0, 0

if member == 1 :
    print(1)

else :
    while(check == 0):
        if(status[i] > total -(i+1)) :
            print(group)
            check = 1
        else :
            group += 1
            i += status[i]
            if(i > total -1) :
                print(group)
                check += 1
