"""
Longest increase sequence

ex ) abbc
a < b =b <c : 값 3

abcabce

1,2,3,1,2,3,4
:값 4

"""

def print_IS(seq, x):
        for i in range(len(seq)):
                if x[i]:
                        print(seq[i], end="")
                else:
                        print("_", end="")
        print()

def LIS_DP(seq):
        # code here
        x = [0]*len(seq)
        DP = [1] * len(seq)
        n=len(seq)

        for i in range(1,n):
                for j in range(0,i):
                        if seq[j] < seq[i]:
                                DP[i] = max(DP[i],DP[j]+1)

        return max(DP),x

seq = input()  # 알파벳 소문자로만 구성된 string 하나가 입력된다
lis, x = LIS_DP(seq)
print(lis)

"""


기저값 : 모든 배열 1  알파뱃 하나가 최소로 있으며 ,cba 와 같은 내림차순일때.
점화식 :
i 시점에서   0<=j<= i-1 이고 문자열  크기가  j 번째< i 번째일때.
DP[i] = max(DP[i],DP[j]+1) 

결과 dp 중 max 값 = 최대 길이 값

평균 : o(n*i) 

최악의 경우 :  i = n 일때  >>>  o(n^2) 


"""
