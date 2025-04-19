"""
https://www.codetree.ai/missions
n * n크기의 직사각형의 가운데에서 시작하여 오른쪽, 위, 왼쪽, 아래 순서로 
더 이상 채울 곳이 없을 때까지 회전하며 숫자를 적어나가려고 합니다. 
숫자는 1부터 시작한다고 했을 때, 다음과 같은 모양으로 숫자들을 쭉 채우는 코드를 작성해보세요.


"""

# 변수 선언 및 입력
n = int(input())
answer = [
    [0 for _ in range(n)]
    for _ in range(n)
]
visited = [
    [0 for _ in range(n)]
    for _ in range(n)
]



def can_go(new_x, new_y):
    # 나아가려는 위치가 직사각형 안에 들어 있는지 확인하고
    # 들어있다면 아직 방문한적이 없는 곳인지 판단합니다.
    if 0 <= new_x and new_x < n and 0 <= new_y and new_y < n and visited[new_x][new_y] == 0:
        return True
    else:
        return False


# direction에 따라 바뀌는 (x, y)의 변화량인 dx, dy를 정의합니다.
dxs, dys = [0, -1, 0, 1], [1, 0, -1, 0]

curr_x = int((n-1)/2)  # 시작은 (중앙) 입니다.
curr_y = curr_x

direction = 0  # 0: 오른쪽, 1: up, 2: 왼쪽, 3: down

# 처음 시작 위치에 초기값을 적습니다.
answer[curr_x][curr_y] = 1
visited[curr_x][curr_y] = True

# n*m개의 알파벳을 적어야 합니다.
for i in range(2 ,(n * n)+1):  # i번째 문자를 어디에 적을지 결정합니다.
    while True:  # 나아갈 수 있을때까지 방향을 바꿔가며 확인해봅니다.
        # 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
        next_x, next_y = curr_x + dxs[direction], curr_y + dys[direction]
        # 그 위치로 나아갈 수 있는지 확인합니다.
        if can_go(next_x, next_y):
            # 나아갈 수 있다면 위치를 갱신해주고 배열에 올바른 값을 채워넣습니다.
            curr_x, curr_y = next_x, next_y
            visited[curr_x][curr_y] = True
            answer[curr_x][curr_y] = i
            direction = (direction + 1) % 4
            break
        else:
            direction = direction - 1

# 출력:
for i in range(n):
    for j in range(n):
        print(answer[i][j], end=' ')
    print()
