## 변수 선언

a = 'p ig'
print(a.split(" "))
b = 'd'

c = a+b
print(c)

a = 1
print(a) ## ㄹㅈㄷ

family = ['mother', 'father']
print(family)

numberList = [1,2,3]
numberList.remove(2)
print(numberList)

x = 'banana'
print(x[2:4])


my_dict = {'a': 1, 'b': 2}
print(my_dict)
my_dict['c'] = 3
print(my_dict)
value = my_dict.get('d', 'Not Found custom')  # 'Not Found'

my_set = {1, 2, 3}
my_set.add(4)  # {1, 2, 3, 4}
my_set.remove(1)  # {2, 3, 4}

if 2 in my_set:
    print("2 is in the set")

my_list = [1, 2, 3]
my_list.append(4)  # [1, 2, 3, 4]
my_list.insert(1, 5)  # [1, 5, 2, 3, 4]

my_list.remove(5)  # [1, 2, 3, 4]
value = my_list.pop(1)  # [1, 3, 4], value = 2


## 자료구조
# 스택
print("Stack is just using list")
thisIsStack = [1,2,3]
print(thisIsStack.pop())
print(thisIsStack.append(3))
print(thisIsStack)

#Que
from collections import deque

queue = deque()

# 큐에 요소 추가 (Enqueue)
queue.append(1)
queue.append(2)
queue.append(3)
first = queue.popleft()  # 1 반환, 큐는 [2, 3]
print(first)
print(queue)
print(queue.pop()) # stack 처럼 사용 가능

#Heap

# python support only min heap
import heapq

min_heap = []

# 힙에 요소 추가 (Push)
heapq.heappush(min_heap, 3)
heapq.heappush(min_heap, 1)
heapq.heappush(min_heap, 2)

# 힙에서 가장 작은 값 제거 (Pop)
smallest = heapq.heappop(min_heap)  # 1 반환, 힙은 [2, 3]


# 우선순위 큐 생성 (최소 힙)
priority_queue = []

# (우선순위, 값)의 튜플로 요소 추가
heapq.heappush(priority_queue, (2, 'task 2'))
heapq.heappush(priority_queue, (1, 'task 1'))
heapq.heappush(priority_queue, (3, 'task 3'))

# 우선순위가 가장 높은 요소 추출 (우선순위가 낮은 값이 먼저)
top_task = heapq.heappop(priority_queue)  # (1, 'task 1')


max_heap = []

# 힙에 요소 추가 (Push, 음수 값으로 넣음)
heapq.heappush(max_heap, -3)
heapq.heappush(max_heap, -1)
heapq.heappush(max_heap, -2)

# 힙에서 가장 큰 값 제거 (Pop, 다시 양수로 변환)
largest = -heapq.heappop(max_heap)  # 3 반환, 힙은 [-2, -1]


# 정렬 하나 기준 잡을때

array = [[1, 3], [4, 1], [2, 2]]

# 두 번째 값을 기준으로 정렬 (오름차순)
sorted_array = sorted(array, key=lambda x: x[1])
print(sorted_array)  # [[4, 1], [2, 2], [1, 3]]

# 두 번째 값을 기준으로 정렬 (내림차순)
sorted_array = sorted(array, key=lambda x: x[1], reverse=True)
print(sorted_array)  # [[1, 3], [2, 2], [4, 1]]






