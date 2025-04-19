
"""
문자열 A가 주어졌을 때 문자열 A에 Run-Length Encoding을 적용한 이후의 결과를 구해보려고 합니다. Run-Length Encoding이란 간단한 비손실 압축 방식으로, 연속해서 나온 문자와 연속해서 나온 개수로 나타내는 방식입니다.

예를 들어, 문자열 A가 aaabbbbcbb인 경우 순서대로 a가 3번, b가 4번, c가 1번 그리고 b가 2번 나왔으므로 Run-Length Encoding을 적용하게 되면 a3b4c1b2가 됩니다.

문자열 A가 주어졌을 때, Run-Length Encoding을 적용한 이후의 결과를 출력하는 프로그램을 작성해보세요.

https://www.codetree.ai/missions
입력:
aaabbbbcbb

출력:
8
a3b4c1b2
"""
# basic  코스 응용

tmpcheck = input()
buildword = []
buildcheck = 1
for i in range(len(tmpcheck)):
    if i + 1 == len(tmpcheck):
        buildword.append(tmpcheck[i])
        buildword.append(str(buildcheck))
        break

    if tmpcheck[i] == tmpcheck[i + 1]:
        buildcheck += 1
    else:
        buildword.append(tmpcheck[i])
        buildword.append(str(buildcheck))
        buildcheck = 1

result = ""
for x in range(len(buildword)):
    result += buildword[x]

print(len(result))
print(result)
