import sys
sys.setrecursionlimit(10000)

n = int(input())

m = int(n/2)
listans =[]
comb = []
array = [list(map(int, sys.stdin.readline().split())) for i in range(n)]

def search_combi(count):
    if count == m :
        comb.append(listans[:])
        return

    for x in range(1,n+1):

        if len(listans) >=1 and listans[-1] == x:
            continue

        if len(listans) >= 1 and listans[-1]+1 > x:
            continue

        else :
            listans.append(x)
            search_combi(count + 1)
            listans.pop()

    return

search_combi(0)

def split_list(a_list):
    half = len(a_list)//2
    return a_list[:half], a_list[half:]

left, right = split_list(comb)
right.reverse()

min = 10000000000
for arr in range(len(right)):
    value = 0
    for i in range(len(right[0])):
        for j in range(i+1,len(right[0])):
            up = array[right[arr][i] - 1][right[arr][j] - 1] + array[right[arr][j] - 1][right[arr][i] - 1]
            down = array[left[arr][i] - 1][left[arr][j] - 1] + array[left[arr][j] - 1][left[arr][i] - 1]
            tmp=abs(up - down)
            value += tmp
    if min > value:
        min = value

print(min)