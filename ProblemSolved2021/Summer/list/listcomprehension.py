



size =10
arr =[i* 2 for i in range(size)]
print(arr)


arr2 = [i*i for i in range(size)]

arr3 = [0 for _ in range(size)]


print(arr2,arr3)

word = '가나다'
print([c*2 for c in word])


size = 10
arr = [n for n in range(1, 11) if n % 2 == 0]
print(arr)


# 조건문을 여러개 쓸 시 명시적 and 를 사용하면 invalid SYNTAX 라 나
arr = [n for n in range(1, 31) if n % 2 == 0 if n % 3 == 0]


arr = [n for n in range(1, 16) if n % 2 == 0 or n % 3 == 0]
# 한 if 문 내에서 or 연산 해결
print(arr)


arr = [[1, 2, 3],
       [4, 5, 6],
       [7, 8, 9],
       [10, 11, 12],
      ]

flat_one = [n for row in arr for n in row]
print(flat_one)

###

flat_one2 = []
for row in arr:
    for n in row:
        flat_one2.append(n)

print(flat_one2)


squared_list = [[n ** 2 for n in row] for row in arr]
print(squared_list)








