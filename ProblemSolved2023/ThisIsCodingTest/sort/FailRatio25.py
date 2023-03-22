# count down fail ratio

def sol(n,stages):
    answer =[]
    total = len(stages)


    for i in range(1,n+1) :
        number = stages.count(i)

        if total == 0 :
            fail = 0
        else:
            fail = number/total

        answer.append((i,fail))
        total -= number
    answer = sorted(answer,key=lambda ratio:ratio[1],reverse=True)
    answer = [i[0] for i in answer]
    return answer



