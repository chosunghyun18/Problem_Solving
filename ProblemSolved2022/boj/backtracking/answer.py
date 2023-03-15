import itertools


def backtracking_14889():
    n = int(input())  # 사람 명 수
    table = []
    for _ in range(n):
        table.append(list(map(int, input().split())))

    people = [i for i in range(n)]  # 사람 목록  1,2,3,46
    stats = []  # 능력치의 차를 저장하는 리스트

    # 팀을 나누는 과정
    tmp_team = list(itertools.combinations(range(n), n // 2))

    for team in tmp_team:
        start = team
        link = [p for p in people if p not in start]

        hap_start = 0  # 스타트의 합
        hap_link = 0  # 링크의 합
        for i in start:
            for j in start:
                hap_start += table[i][j]

        for i in link:
            for j in link:
                hap_link += table[i][j]

        if abs(hap_start - hap_link) == 0:  # 차가 0이면 더이상 계산 안해도 됨
            print(0)  # 0 출력하고 끝냄
            return
        else:
            stats.append(abs(hap_start - hap_link))  # 0이 아니면 리스트에 넣음

    print(min(stats))  # 최소값을 출력


backtracking_14889()