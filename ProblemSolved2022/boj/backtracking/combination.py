
n, m = tuple(map(int,input().split()))
# n = int(input())
# m = int(n/2)
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
        if len(list) >=1 and list[-1] == x:
            continue
        if len(list) >= 1 and list[-1]+1 > x:
            continue
        else :
            list.append(x)
            search_combi(count + 1)
            list.pop()
search_combi(0)