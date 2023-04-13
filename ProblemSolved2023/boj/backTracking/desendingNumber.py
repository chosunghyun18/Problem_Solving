n = int(input())




re =[0]

def check(check):
    nl = list(map(int,str(check).replace(''," ").split()))
    for i in range(len(nl)):
        if i+1 == len(nl):
            break
        if  nl[i] <= nl[i+1] :
            return False

    nlc =nl[:]
    nl.sort(reverse=True)
    if nl != nlc:
        return False
    return True




count  = 0
checknum = 1
while count != n :
    if checknum <= 10 :
        count += 1
        re.append(checknum)
    elif check(checknum) :
        count+=1
        re.append(checknum)
    checknum += 1


if len(re)-1 != n :
    print(-1)
else: print(re[n])




