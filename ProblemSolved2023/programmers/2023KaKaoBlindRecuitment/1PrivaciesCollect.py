
def solution(today, terms, privacies):
    # print("today :",today)
    ty ,ym ,td = map(int ,today.split("."))
    # print(ty,ym,td)
    todayTotal = ((ty - 2000) * 12 + ym ) *28  + td
    # print(todayTotal)

    answer = []
    # print("terms : ",terms)
    # print("privacies : ",privacies)

    tarr = []
    for term in terms :
        a ,b = term.split()
        tarr.append((a ,int(b ) *28))
    # tarr :  [('Z', 84), ('D', 140)]
    # print("tarr : " ,tarr)

    parr = []
    for per in privacies :
        period , term = per.split()

        ty ,ym ,td = map(int ,period.split("."))
        tmpTotal = ((ty - 2000) * 12 + ym ) *28  + td
        parr.append((tmpTotal ,term))
    # print("parr : ",parr)

    count = 1
    for pnode in parr :
        checkTerm =pnode[1]
        for check in tarr :
            if(checkTerm == check[0]) :
                cal = todayTotal - pnode[0]
                # print(  cal ,check[1])
                if(cal >= check[1]) :
                    # print(count)
                    answer.append(count)
        count += 1

    return answer

