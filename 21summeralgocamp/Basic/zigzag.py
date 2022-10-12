"""
지그재그로 숫자 채우기

by codetreeai
"""

# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))
answer = [
    [0 for _ in range(m)]
    for _ in range(n)
]

count = 0

# Step 1:
for col in range(m):
    if col % 2 == 0:
        # Case 1:
        for row in range(n):
            answer[row][col] = count
            count += 1
    else:
        # Case 2:
        for row in range(n - 1, -1, -1):
            answer[row][col] = count
            count += 1

# 출력:
for row in range(n):
    for col in range(m):
        print(answer[row][col], end = ' ')
    print()
