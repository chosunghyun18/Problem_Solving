# python copy style


# deep 
# could be change both 
originList = [1,23,5]
newList = originList
newList.pop()

print("origin" ,originList)
print("NewList" ,newList)
"""
origin [1, 23]
NewList [1, 23]
"""

# shallow = different Memory Address

A = [10,22,13,14]

B =A[:]

A.pop()

print(A)
print(B)

"""
[10, 22, 13]
[10, 22, 13, 14]
"""