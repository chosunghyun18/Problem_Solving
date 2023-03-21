key = input()
locker = input()


def rotate_to_90degree(a):
    n = len(a) # 행
    m = len(a[0])
    result = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m) :
            result[j][n-i-1] = a[i][j]
    return result

# 중간 부분 1 확
def check(new_lock) :
    lock_length = len(new_lock)
    for i in range(lock_length,lock_length*2) :
        for j in range(lock_length , lock_length*2):
            if new_lock[i][j] != 1 :
                return False
    return True

def sol(key,lock):
    n = len(lock)
    m = len(key)

    # 길이 연장
    new_lock = [[0]*(n*3) for _ in range(n*3)]

    # 중앙 부분에 자물쇠 넣
    for i in range(n) :
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]

    # 4방향 확
    for rotation in range(4):
        key = rotate_to_90degree(key) # 회전인
    for x in range(n*2):
        for y in range(m*2):

            # match key in locker
            for i in range(m):
                for j in range(m):
                    new_lock[x+i][y+i] += key[i][j]
            if check(new_lock) == True :
                return True

            #put out
            for i in range(m):
                for j in range(m):
                    new_lock[x+i][y+i] -= key[i][j]

    return False















