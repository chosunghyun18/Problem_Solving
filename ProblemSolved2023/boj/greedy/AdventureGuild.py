"""
여행을 떠날 수 있는 그룹 수의 최솟 값을 구하시오
"""

member = int(input())
status = list(map(int,input().split()))
status.sort()
group,check,i = 0
total = len(status)
if member == 1 :
    print(1)

else :
    while(check == 0):
        if(status[i] > status[i] -(i+1)) :
            print(group)
            break
        else :
            i += status[i]
            group+=1
