def solution(problems):
# 가능한 모든 점수 조합의 최대 개수를 저장
    max_scores = 0
    # 모든 가능한 점수 분배 조합을 확인하는 재귀 함수
    def dfs(idx, scores):
        nonlocal max_scores

        # 모든 문제에 대한 점수 분배 완료
        if idx == len(problems):
            max_scores = max(max_scores, len(scores))
            return

        score, groups = problems[idx]

        # 테스트 케이스 그룹이 1개인 경우 또는 총점이 1인 경우
        if groups == 1 or score == 1:
            new_scores = set(scores)
            for s in scores:
                new_scores.add(s + score)
            dfs(idx + 1, new_scores)

        # 테스트 케이스 그룹이 2개인 경우
        else:
            for p1 in range(1, score):
                p2 = score - p1
                new_scores = set(scores)
                for s in scores:
                    new_scores.add(s + p1)
                    new_scores.add(s + p2)
                    new_scores.add(s + score)
                dfs(idx + 1, new_scores)

    # 0점부터 시작
    dfs(0, {0})
    return max_scores
'''
[[6, 2], [4, 2]]
[[10, 1], [1, 1], [3, 2]]
'''
