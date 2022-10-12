"""
특정 조건에 맞게 k개 중에 1개를 n번 뽑기
1부터 K 사이의 숫자를 하나 고르는 행위를 N번 반복하여 나올 수 있는 모든 서로 다른 순서쌍을 구해주는 프로그램을 작성해보세요. 단, 연속하여 같은 숫자가 3번 이상 나오는 경우는 제외합니다.

예를 들어 K이 2, N이 3인 경우 다음과 같이 6개의 조합이 가능합니다.

1 1 2

1 2 1

1 2 2

2 1 1

2 1 2

2 2 1

입력 형식
첫째 줄에 K와 N이 공백을 사이에 두고 주어집니다.

1 ≤ K ≤ 4

1 ≤ N ≤ 8

출력 형식
조건을 만족하는 서로 다른 순서쌍의 개수 만큼의 줄에 걸쳐 한 줄에 하나씩 순서쌍의 상태를 공백을 사이에 두고 출력합니다. 이때 앞에서 부터 봤을 때 사전순으로 앞선 순서쌍부터 출력합니다.

입출력 예제
예제1
입력:
2 1

출력: 
1
2
예제2
입력:
2 3

출력: 
1 1 2
1 2 1
1 2 2
2 1 1
2 1 2

"""



k,n = tuple(map(int,input().split()))
list =[]

def print_list():
    for x in list:
        print(x,end=' ')
    print()

def search_differ_permut(count):
    if count == n :
        print_list()
        return

    for x in range(1,k+1):
        if len(list) >= 2 and list[-1] == list[-2] and list[-2] == x:
            continue
        else :
            list.append(x)
            search_differ_permut(count + 1)
            list.pop()


search_differ_permut(0)
