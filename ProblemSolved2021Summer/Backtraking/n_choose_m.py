# COMbination      n C m
"""
n개 중에 m개 뽑기
1부터 N 사이의 숫자 중 M개의 숫자를 골라 만들 수 있는 모든 조합을 구해주는 프로그램을 작성해보세요.

예를 들어 N이 4, M이 3인 경우 다음과 같이 4개의 조합이 가능합니다.

1 2 3

1 2 4

1 3 4

2 3 4

입력 형식
첫째 줄에 N과 M이 공백을 사이에 두고 주어집니다.

1 ≤ M ≤ N ≤ 10
출력 형식
조합의 개수 만큼의 줄에 걸쳐 한 줄에 하나씩 조합의 상태를 공백을 사이에 두고 출력합니다. 이때 앞에서 부터 봤을 때 사전순으로 앞선 조합부터 출력하며, 한 조합 내에서는 숫자들을 오름차순으로 정렬하여 출력합니다.

입출력 예제
예제1
입력:
3 2

출력: 
1 2
1 3
2 3
예제2
입력:
4 3

출력: 
1 2 3
1 2 4
1 3 4
2 3 4

"""


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

        if len(list) >=1 and list[-1] == x:
            continue

        if len(list) >= 1 and list[-1]+1 > x:
            continue

        else :
            list.append(x)
            search_combi(count + 1)
            list.pop()

search_combi(0)
