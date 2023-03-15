
def LIS_DP(seq,n):
    # code here

    DP = [1] * n
    for i in range(1, n):
        for j in range(0, i):
            if seq[j] < seq[i]:
                DP[i] = max(DP[i], DP[j] + 1)
    print(DP)
    return max(DP)

n = int(input())
seq = list(map(int,input().split()) )

lis = LIS_DP(seq,n)

print(lis)