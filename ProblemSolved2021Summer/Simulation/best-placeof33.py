"""
N * N 크기의 격자 정보가 주어집니다. 이때 해당 위치에 동전이 있다면 1, 없다면 0이 주어집니다. 
N * N 격자를 벗어나지 않도록 3 * 3 크기의 격자를 적절하게 잘 잡아서
해당 범위 안에 들어있는 동전의 개수를 최대로 하는 프로그램을 작성해보세요.

첫 번째 줄에는 격자의 크기를 나타내는 N이 주어집니다.

두 번째 줄부터는 N개의 줄에 걸쳐 격자에 대한 정보가 주어집니다.
각 줄에는 각각의 행에 대한 정보가 주어지며, 이 정보는 0또는 1로 이루어진 N개의 숫자로
나타내어지며 공백을 사이에 두고 주어집니다.

N * N 격자를 벗어나지 않으면서, 3 * 3 크기 격자 내에 들어올 수 있는 최대 동전의 수를 출력해주세요.


input:
3
1 0 1
0 1 0
0 1 0

출력: 
4
"""



n = int(input())
given =[ tuple(map(int,input().split()))
        for _ in range(n)]

max = 0
count = 0
# 좌펴ㅛ 각각 0 ,1 ,2 더 함
for x in range( n - 2) :
    for y in range(n - 2):

        for i in range(3):
            i = x + i
            for j in range(3):
                j= j+y
                if given[i][j] == 1:
                    count += 1
        if max < count:
            max = count

        count = 0
print(max)





##. we can  use different solution  sum all of the number in 3by 3 dimension grid
# 변수 선언 및 입력
n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]


# (row_s, col_s) ~ (row_e, col_e) 사이의 금의 개수를 계산합니다.
def get_num_of_gold(row_s, col_s, row_e, col_e):
    return sum([
        grid[i][j]
        for i in range(row_s, row_e + 1)
        for j in range(col_s, col_e + 1)
    ])


max_gold = 0

# (row, col)이 3 * 3 격자의 좌측 상단 모서리인 경우를 전부 탐색합니다. 
for row in range(n):
    for col in range(n):
        # 3 * 3 격자가 n * n 격자를 벗어나는 경우는 계산하지 않습니다.
        if row + 2 >= n or col + 2 >= n:
            continue
        
        num_of_gold = get_num_of_gold(row, col, row + 2, col + 2)
            
        # 최대 금의 개수를 저장합니다.
        max_gold = max(max_gold, num_of_gold)

print(max_gold)


