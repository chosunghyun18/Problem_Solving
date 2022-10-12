import timeit

Hs ,Hc= 0,0
def heap_sort() :
    a =0
    global Hs
    a+=1
    if a == 1  :
        Hs = 2

    return a,Hs


print(Hs)
print("time =",timeit.timeit("heap_sort()",globals=globals(),number=1))
print("  comparisoon = {:10d},swaps= {:10d}\n".format(Hc,Hs))
print(Hs)





"""
전역 변수 선언 Hs
함수 안에서 원하는 값으로 변형시 상단 
global 로 호출


"""
"""
output >>

0
time = 1.3160000000289607e-06
  comparisoon =          0,swaps=          2

2

"""
