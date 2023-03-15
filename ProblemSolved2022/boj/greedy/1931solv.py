n = int(input())
a = [tuple(map(int,input().split()))for _ in range(n)]
#print(a)

# 가정 - given data same start time >>>>>  sorted  back  ex) 8 11  , 8 12
#a_s = sorted(a,key = lambda x:x[0])
a_s  = sorted(a,key = lambda x:x[0])
a_l = sorted(a_s,key = lambda x:x[1])
# greedy -> 수업시간 가장 빨리 끝나는 강의 부터 선택한다.

# 종료값을 기준 정렬에서 시작점만 모은 리스트
a_l_s = [s for s,_ in a_l]

# 종료값을 기준 정렬에서 종료점만 모은 리스트
a_l_l = [l for _ ,l in a_l]
#
print(a_l)
print("als:",a_l_s)
print("all:",a_l_l)

p = 0
result = 1

for x in range(1,n):
    if a_l_s[x] >= a_l_l[p] :
        result += 1
        p = x

print(result)