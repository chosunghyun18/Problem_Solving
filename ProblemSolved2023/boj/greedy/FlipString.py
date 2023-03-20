data = input()

check = data[0]

result =[]
for i in range(1,len(data)):
    if check[-1] != data[i] :
        result.append(check)
        check = data[i]

    else:
        check += data[i]
result.append(check)

# print(result)

o = 0
z = 0
for i in result :
  if i[0] == "0":
    o+=1
  else: z+=1

print(min(o,z))
"""
data = input()
count0 = 0 
count1 = 0

if data[0] =='1' :
    count0 +=1
else :
    count1 +=1

for i in range(len ~ :
    if data[i] != data[i+1]:
        # next number is change to 1
        if data[i+1] == "1":
            count0 +=1
        # next number is change to 0
        else :
            count1 +=1
"""