# this is second

n = int(input())

cards  = []

for _ in range(n):
    cards.append(int(input()))


cards.sort()


def count(cards) :
    arr = []
    n = len(cards)
    if n == 1 :
        return cards
    else :
        for x in range(0,n,2):
            if x == n -1 :
                arr.append(cards[x])
            else :
                arr.append(cards[x]+cards[x+1])
        cards = arr
        return count(cards)



print(count(cards))
