import heapq

n = int(input())
am = []
for _ in range(n):
    am.append(int(input()))
result = 0

# for i in range(n):
#     heapq.heappush(heap,am[i])
heapq.heapify(am)
# print(am)
# heap q > always min heap

for i in range(n-1):
    a = heapq.heappop(am)
    b = heapq.heappop(am)
    result += (a + b)
    heapq.heappush(am,a+b)


print(result)