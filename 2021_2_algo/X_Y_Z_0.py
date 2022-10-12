# find x+y to make a componet of t


#  using binary search
def two_sum(X, Y, t):
    for y in Y:
        # s in int which for search
        s = -(y + t)
        if X[0] == s or s == X[-1]:
            return True
        # compare with edge
        if X[0] < s < X[-1]:
            s_i = 0
            l_i = len(X) - 1
            while s_i <= l_i:
                m_i = (s_i + l_i) // 2

                if s == X[m_i]:
                    return True

                elif s < X[m_i]:
                    l_i = m_i - 1
                else:
                    s_i = m_i + 1

        return False


# if  x+y = t  return True


# 입력 받는 공백 포함 하는 배열
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

A.sort()


# C 기준 호출
a = 0
for t in C:
    if two_sum(A, B, t) == True:
        print('True')
        a = 1
        break
    else:
        continue

if a ==0 :
    print("False")


# Big_O
"""
    알고리즘의 수행시간을 Big_O를 이용해 분석을 해본다 .
    작성한 프로그램은 함수 two_sum 정의 부분과 호출부 그리고 입력부로 이루어져 있다. 
    
    입력 값을 받은후 배열에저장을 한후 주어진 배열을 파이썬 내장 함수를 이용하여 정렬을 한다. 파이썬 내장 함수인 sort()는 
     TIM SORT를 사용한다 , merge sort를 최적화 시킨것으 , 최악의 경우와 평균의 경우 O( nlog(n) ), 최고의 경우 O(n)이라고 한다.

    
    함수 two_sum 함수는 정렬된 배열에서 이진 탐색을 이용하여 작성을 했다 전체 N 개의 숫자가 있다고 하면 원하는 값을 탐색하는데 
    1/2* n 인 지점을 구한후 탐색 하고자 하는 값과 비교를 하며 값이 크거나 작거나 두가지의 경우를 비교함으로 반복 적으로 2^m 가지로 탐색을한다. 
    2^m =  n    /   n은 주어진 입력값, len(A) = n   / m 은 시행횟수  
    결론적으로 two_sum(X,Y,t)속  연산 알고리즘은  최악의 경우 log2(n) 만큼 걸린다.  
    
    two_sum(X,Y,t) 은  for 문에서 입력된 Y 의 길이값 만큼 최악의 경우 N 번 호출 한다.
    
    즉 프로그램상  two_sum(A,B,t) 을 Big_O로 표현하면  O(n*log(n)) 이다     

    전체 수행시간을 big_O 를 이용하여 표기를 하면 O( N^2 *log(n)) 이다. 


"""
