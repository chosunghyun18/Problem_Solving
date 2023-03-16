"""
Q:
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)


input : 첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.
"""

# make number into list of number

# count

originSet = ["0","1","2","3","4","5","7","8","6","6"]

checkSet = originSet[:]

roomNumber = input().replace('9', '6')
roomNumber = [num for num in roomNumber]

numberOfSet = 1

print(roomNumber)
if len(set(roomNumber)) == 1: # Check if all digits are the same
    print(numberOfSet)
else:
    for oneDigit in roomNumber:
        # check one digit is in set if not count +1 in setnumber + init else , erase set
        if oneDigit in checkSet:
            checkSet.remove(oneDigit)
        else:
            numberOfSet +=1
            checkSet = originSet[:]
            checkSet.remove(oneDigit)
    print(numberOfSet)

