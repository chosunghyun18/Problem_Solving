import sys
sys.setrecursionlimit(10000)

def B(k, col):  # check if the k-th queen can be placed at (k, col)
        #compare with befrwre  q chek x
        for i in range(1,k):
                if (x[i] - col) == 0 or abs((x[i] - col))  == k-i :
                        return False
        return True


# 코드 작성

def nQueens(k):  # decide a valid x[k]
        global sol  # sol: 전역 변수로 사용한다는 의미
        if k > n:
                sol += 1  # 해가 하나 발견되어 갯수 증가
                return
        for col in range (1,n+1):
                if B(k, col):
                        x[k] = col
                        nQueens(k + 1)


n = int(input())
x = [0] * (n+1)  # 해를 기록
sol = 0  # 해의 개수를 기록
nQueens(1)
print(sol)
