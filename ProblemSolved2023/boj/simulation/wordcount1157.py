

from collections import Counter
word = input().upper().replace(""," ").split()
counter = Counter(word)
case = counter.most_common()

ans = case[0][0]

check = case[0][1]
for item in case :
    if item[1] == check:
        if item[0] != ans :
            ans = "?"
            break

print(ans)
