
data = list(map(int,input().replace(""," ").split()))
print(data)

halfPoint = int(len(data) / 2)

left = data[:halfPoint]
right = data[halfPoint:]
print(left)
print(right)


l ,r = 0 ,0

for i in left:
    l+=i

for i in right:
    r += i

if l==r :
    print("LUKY")
else:
    print("Ready")