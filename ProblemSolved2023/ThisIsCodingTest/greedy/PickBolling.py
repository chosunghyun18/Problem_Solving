
N ,M = map(int,input().split())

w = list(map(int,input().split()))

# N,M =8, 5
# w ="1 5 4 3 2 4 5 2"
# w = list(map(int,w.split()))

total = (N*(N-1)/2)

w.sort()

tmp = [w[0]]
result = []
count = 0

for i in range(1,N):

    if w[i]!= tmp[-1]  :
        if  len(tmp) > 1 :
            result.append([tmp[-1],len(tmp)])
        tmp = [w[i]]
    else :
        tmp.append(w[i])

result.append([tmp[-1],len(tmp)])


sumall = 0

for x in result:
    sumall += (x[1] * (x[1]-1)) * ( 1/2 )


print(int(total -sumall))