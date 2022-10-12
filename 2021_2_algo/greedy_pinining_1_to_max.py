#그리디 알고리즘 pin 문제 / pin을 1 개 꽂아 구할 수 있는 최대 막대 수
# max = 핀하나로 꽂는 최대 막대수

# 기준 . 오름차순으로 막대 마지막 시점으로 정렬된 상태의 막대 왼쪽p[j]에 핀을 꽂은후 막대 수를 계산한다.

#알고리즘 핀 한개의 꽂힌 막대의수 = p[j] = (j 보다 작은 시작점 개수)-(j 보다 작은 끝점 개수)+{(j 와 같은 시작점 개수)+(j 와 같은 끝점 개수)}

# j 일 시 막대 끝점수 = j+1 , 고려 하자.

# j 위치에서 앞에서 선행한 시작점과 끝점의 개수는 인덱스를 알면 구할수있다.
#이전 단계에서 호출해서 새로 갱신 하며 막대의 수를 구해 나간다.
# stack 을 이용하여 계산시 연산 시간이 늘어나, dp 방식과 유사한 방법을 이용한다.

#리스트 원소 (시작 시점,끝시점)
a = [(11, 23), (8, 20), (13, 27), (5, 10), (12, 25), (9, 14), (14, 22), (3, 13), (2, 10), (9, 16)]
n = len(a)

# 시작 값 기준 정렬
a_s= sorted(a,key=lambda x:x[0])

# 종료 값 기준 정렬
a_l= sorted(a,key=lambda x:x[1])

# 시작 값을 기준으로 정렬된 map의 원소를 갖는 리스트에서 x[0]= 시작점만 뽐아 리스트를 만든다. 
ass = [s for s,_ in a_s]

# 끝 값을 기준으로 정렬된 map의 원소를 갖는 리스트에서 x[1]= 끝점만 뽐아 리스트를 만든다. 
asl = [l for _,l in a_l]

li =0
si =0
# memo end point in list ss
max = 1
# 초기 끝값 개수 인덱스 발견
while asl[li]==asl[li+1]:
    li+=1

tmpn=0
#초기 선제 값 끝값 발견

while asl[li] >= ass[si] :
    si+=1
    tmpn += 1
li+=1

if max < tmpn:
    max =tmpn


while li < n:
    if asl[li] == asl[li-1]:
        li += 1
    else:
        tmpn = si -li
        if si < n-1:
            while ass[si] <= asl[li]:
                si+=1
                tmpn+=1
                if si == n-1:
                    if ass[si]==asl[li]:
                        tmpn += 1
                    break
        if max < tmpn :
            max =tmpn
        li += 1
if max < tmpn:
    max =tmpn
print(max)
