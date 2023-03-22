
M ,N = 4 , 3

array = [[0] * M for _ in range(N)]
print(array)





num = 13579
x = [int(a) for a in str(num)]
print(x)
"""
[1, 3, 5, 7, 9]
"""
print(sum(x))


my_string="Delft, Stack, Netherlands"

transformed_string=my_string.replace(",","")

print("Transformed String is:")

"""
Delft Stack Netherlands
"""

data =dict()
data['apple'] = "this is apple "
print(data)


testlist = []
testlist.append(1)
testlist.append(2)

print("this is min nujmber of list",min(testlist))


testlist.remove(1)
print(testlist)
print(testlist.count(2))


scores = []
scores.append([1,214,13])
scores.append([11,22,23])
scores.append([12,23,33])
scores.append([13,24,34])

# print(array.sort())

print(scores)
array= sorted(scores,key=lambda score:score[1])
print(array)


a = [1,5,3,4,5]
c = a [:]
b = a[0:-1] # expect [1,2,3]
print(b)
b.sort()

print(c)
c[0:2+1] = b
print(c)
