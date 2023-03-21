
numbers = list(map(int,input().replace(""," ").split()))

result = ["+"]
for i in numbers:
    if i == 0:
        result.pop()
        result.append("+")
        result.append(i)
        result.append("+")
        continue
    else:
        result.append(i)
        result.append("*")

given = result[1:len(result)-1]


ans = given[0]
for i in range(1,len(given)):
   if given[i-1] == '+' :
        ans += given[i]
   elif given[i-1] == '*' :
       ans *= given[i]
   else:
       continue
print(ans)

"""
case ! 0 and 1 모두 생각   

data = input()
result = int(data[0]) # 문자열 바로 타입 변환
for i in range(1,len(data)):
    num = int(data[i])
    if num <= i  or result <=1:
        result += num
    else : 
        result *= num
    
print(result)



# eval("3+5") 파이썬 내장 string 을 계산 해주는 함수
"""