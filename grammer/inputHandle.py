

# get input is basic  of string

# a  is string
a = input()

# this is list
a.split()

intNumber = int(input())

listOfInt = input(map(int, input()))




# System read line
import sys
data = sys.stdin.readline().rstrip()
print(data)


n = 3
for x in range(3):
    data = list(map(int,input().split()))

print(data)


# gold mine input
for t in range(int(input())) :
    n ,m = map(int,input().split())
    array = list(map(int,input().split()))

    #  make dp table
    dp = []
    index = 0
    for i in range(n):
        dp.append(array[index:index+m])
        index += m

    print(dp)
