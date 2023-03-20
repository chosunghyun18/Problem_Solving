# data = "K1KA5CB7"
# # data = input().replace(""," ").split()
#
# data = data.replace(""," ").split()
# data.sort()
# print(data)

"
data = input()
result = []
value = 0

for x in data :
    if x.isalpha():
        result.append(x)
    else :
        value += int(x)

result.sort()

if value != 0 :
    result.append(str(value))

print(''.join(result))


