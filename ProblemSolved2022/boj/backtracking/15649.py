n,m = tuple(map(int,input().split()))
list =[]

def print_list():
    for x in list:
        print(x,end=' ')
    print()

def search_combi(count):
    if count == m :
        print_list()
        return

    for x in range(1,n+1):
        # 있으면 pass
        if x in list:
            continue

        else :
            list.append(x)
            search_combi(count + 1)
            list.pop()

search_combi(0)
