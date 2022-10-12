
"""
n 개의 정수를 주어지는 집합 A 에서
정수 S 를 만들 수있는 모든 경우 출력
오름차순


8 7 6 5 3 10 9
15


[1, 4]
[2, 3]
[5]



""""


def print_subset(x):
    print([A[i] for i in range(len(x)) if x[i]])


def subset_sum(k):
    global v
    v_sum = 0
    for i in range(len(x)):
        if x[i] == 1:
            v_sum += A[i]

    if k == len(A):
        if v_sum == S:
            print_subset(x)
            v=1
        else:
            return

    else:
        if v_sum + A[k] <= S:
            x[k] = 1
            subset_sum(k + 1)
        x[k] = 0
        subset_sum(k + 1)


# A = list(set(int(x) for x in input().split()))
# A.sort()
# S = int(input())
v=0
A=[1,2,3,4,5,6,7,8,9 ,-1, -2, -3, -4, -5, -6, -7, -8 ,-9]
S=100
v=0
x = [0] * len(A)
subset_sum(0)

if v!= 1:
    print("[]")
