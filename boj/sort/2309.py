array =[]
total = 0

for _ in range(9):
    g = int(input())
    array.append(g)
    total += g

array.sort()

def solv():
    for j in range(8):
        for i in range(j+1,9):
            if  (total - (array[j]+ array[i])) == 100 :
                array.pop(j)
                array.pop(i-1)
                return array

solv()

for num in array:
    print(num)