#26
import sys

input = sys.stdin.readline
n = input().rstrip()

ans = n
check = "-1"
count = 0

if int(n) < 10 :
    n = "0"+ n

while ans != check :
    count +=1
    if ans == "0":
        break

    check = str(int(n[0])+int(n[1]))
    if int(check)  < 10 :
        check = "0"+check

    n =  n[1] + check[1]
    check = n


print(count)
