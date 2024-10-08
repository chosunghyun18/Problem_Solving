"""
k개 중에 1개를 n번 뽑기
1부터 K 사이의 숫자를 하나 고르는 행위를 N번 반복하여 나올 수 있는 모든 서로 다른 순서쌍을 구해주는 프로그램을 작성해보세요.

예를 들어 K이 3, N이 2인 경우 다음과 같이 9개의 조합이 가능합니다.

1 1

1 2

1 3

2 1

2 2

2 3

3 1

3 2

3 3

입력 형식
첫째 줄에 K와 N이 공백을 사이에 두고 주어집니다.

1 ≤ K ≤ 4

1 ≤ N ≤ 8

출력 형식
서로 다른 순서쌍의 개수 만큼의 줄에 걸쳐 한 줄에 하나씩 순서쌍의 상태를 공백을 사이에 두고 출력합니다. 이때 앞에서 부터 봤을 때 사전순으로 앞선 순서쌍부터 출력합니다.

입출력 예제
예제1
입력:
2 2

출력: 
1 1
1 2
2 1
2 2
예제2
입력:
3 2

출력: 
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3


"""



# 재귀함수 이용
k, n = tuple(map(int, input().split()))

list = []

def print_list():
    for x in list:
        print(x,end=' ')
    print()

def searchpermut(count):
    if count == n:
        print_list()
        return

    for x in range(1,k+1):
        list.append(x)
        searchpermut(count + 1)
        list.pop()

searchpermut(0)
