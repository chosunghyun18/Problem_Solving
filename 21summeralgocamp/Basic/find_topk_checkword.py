"""
Top k 숫자 구하기
N개의 숫자가 주어졌을 때, 오름차순으로 정렬했을 때 k번째 숫자를 출력하는 프로그램을 작성해보세요.
오름차순으로 정렬했을 때 k번째 숫자를 출력합니다.
입력:
3 2
1 2 1

출력: 
1
"""

# 변수 선언 및 입력:
n, k = tuple(map(int, input().split()))
nums = list(map(int, input().split()))

# nums를 정렬합니다.
nums.sort()

# k번째 원소를 출력합니다.
print(nums[k - 1])





"""
순서를 바꾸었을 때 같은 단어인지 판별하기

두 개의 단어가 입력으로 주어질 때 
두 단어에 속하는 문자들의 순서를 바꾸어 동일한 단어로 만들 수 있는지 여부를 출력하는 코드를 작성해보세요.


첫 번째 줄에는 첫 번째 단어가 주어지고, 두 번째 줄에는 두 번째 단어가 주어집니다.

1 ≤ 단어의 길이(n) ≤ 100,000

각 단어에 속하는 문자는 총 128개로 구성되어 있는 아스키 코드로 나타낼 수 있습니다.
"""





# feedback code     100ms~
a1 = list(input())
a2 = list(input())

a1.sort()
a2.sort()

if  a1 ==a2 :
    print("Yes")

else :
    print("No")


    
    
    
"""


#문자열 입력을 받는다.
tmpcheck1 = input()
tmpcheck2 = input()

# 받은 문자 아스키 코드로 변환 후 배열에 저장
w1 = []
for x in range(len(tmpcheck1)):
    w1.append(ord(tmpcheck1[x]))

w2 = []
for x in range(len(tmpcheck2)):
    w2.append(ord(tmpcheck2[x]))


# 정렬 알고리즘
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    lesser_arr, equal_arr, greater_arr = [], [], []
    for num in arr:
        if num < pivot:
            lesser_arr.append(num)
        elif num > pivot:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)


# 입력 받은 문자들 아스키 변환후 정렬
r1 = quick_sort(w1)
r2 = quick_sort(w2)

c = 0
# 배열 크기가 같다면
if len(r1) == len(r2):
    for index in range(len(r1)):
        if r1[index] != r2[index]:
            print("No")
            c =1
            break
        else:
            continue
    if c == 0:     # 문자 총 수 , 각문자 수 맞음
        print("Yes")
# 배열 크기가 다르면 변환 해도 같은 문자 불가 > 문자수 부족
else:
    print("No")

"""
