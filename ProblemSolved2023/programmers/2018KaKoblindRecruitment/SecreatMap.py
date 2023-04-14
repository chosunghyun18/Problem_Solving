"""
from itertools import permutations , combinations ,product

arr = [1,2,3,4,5]
# 순열
an = list(permutations(arr,2))
print(an)

arrc =[1,3,4,5]
# 조합
anc = list(combinations(arrc,2))
print(anc)

arrc =[1,2,3,4]
anp = list(product(arrc,arrc))
print(anp)


3 1
4 5 2
"""
#String handle

n = 28
re =[]
while n >= 1 :
    l = n % 2
    c = n // 2
    print(n,l,c) # 28   0 14
    re.append(l)
    n = c
re.reverse()
print(re)

n =28

print(bin(n)[2:])

def solution(n, arr1, arr2):
    ans = []
    for i in range(n):
        bin_str = bin(arr1[i] | arr2[i])[2:]
        ans.append(("0" *(n - len(bin_str)) + bin_str).replace("1", "#")
                                                      .replace("0", " "))
    return ans






