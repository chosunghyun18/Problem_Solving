import sys

f = sys.stdin.readline

n,m = map(int, f().split())

array = []
for _ in range(n):
    array.append(list(map(int,f().split())))


print(array)

# given situatuon and make 3 wall to protect it
