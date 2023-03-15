"""
# Huffman Coding Algorithm [Greedy]
문자 갯수 n과 빈도수 n개를 입력받는다
node 정의:
   c = 문자
   f = 빈도수
   p = 부모노드
T = n개의 노드로 구성된 min-heap
   - 처음엔 T = [(c1, f(c1), NULL), ..., (cn, f(cn), NULL)]으로 n개의 리프노드들로 구성
while len(T) > 1:
   x = T.deleteMin() # x = 현재 T에서 가장 작은 빈도수의 노드
   y = T.deleteMin() # y = 현재 T에서 두 번째로 작은 빈도수의 노드
   x.p = y.p = z     # x와 y의 부모노드 = z로 지정!
   z = node(x.c+y.c, x.f+y.f)
   T.insert(z) # T에서 x, y는 이미 제거되었고, 대신 z를 삽입

부모노드 정보를 이용해 각 문자에 할당된 비트 수를 계산해 cost 값 출력
"""


# my ncode below 

# f = 빈도수 
from heapq import *

# f = [int(x) for x in input().split()]
f =[13, 5, 11, 7, 15, 1, 14, 20, 10, 12, 9]
n = len(f)
T = []
for i in range(n):
    heappush(T, (f[i], str(i)))


print("this is given t : ")
print(T)
# print(len(T))


while len(T) > 1:
    a = heappop(T)
    b = heappop(T)
    heappush(T, (a[0] + b[0], "(" + a[1] + " " + b[1] + ")"))

s = heappop(T)[1]  # 문자열만 가져온다
print("this is given s: ")
print(s)

s = s.split()
nbits = [0] * n
cnt = 0

print(s)

# if nunber get number and wait until end
for word in s:
    tmp=""
    if word[0] == "(":
        for l in word:
            if l == "(":
                cnt += 1
            else:
                tmp += l
        print("tmp cnt",tmp,cnt)
        nbits[int(tmp)] = cnt

    else :
        cntl = 0
        for l in word:
            if l ==")": break
            else:
                tmp+= l
                cntl += 1
        nbits[int(tmp)] = cnt
        for i in range(cntl,len(word)):
            cnt-=1


# print(nbits)
print("this is answ")
print(nbits)
print(f)


result = []
for x in range(n):
    result.append((nbits[x] * f[x]))

# print(result)
answ = 0
for x in result:
    answ += x

print(answ)
