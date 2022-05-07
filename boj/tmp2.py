


print(4200%5000)
print(4200%17)
# print(4200/5000)
# print(4200//5000)
#


n = 17
result = 0
a = [1,2,3,4,5]

for  i in range(len(a)-1,-1,-1):
    if  n % a[i] == n :
        continue
    else :
        result += n // a[i]
        n = n % a[i]






