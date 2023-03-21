# from collections import  deque
# #도시 , 도로 , 거리 정보, 출발 도시
# n,m,k,x = map(int,input().split())
#
# # graph
# graph = [[] for _ in range(n+1)]
#
# # get all road info ,
# for _ in range(m) :
#     a,b = map(int,input().split())
#     graph[a].append(b)
#
#
# print(graph)
#
#
#
# # 모든 도시 최단 거리 초기화
# distance = [-1]*(n+1)
# distance[x] = 0 # 출발도시까지 거리는 0 으로 설정
#
# print(distance)
#
# # bfs to all node by distance  k  , start in x
#
# city = []
#
# def bfs(check,count,distance) :
#     for i in range(len(check)):
#         debug  = check[i]
#         count += 1
#         if graph[check[i]] == []:
#             if distance[check[i]] == -1 :
#                 distance[check[i]] = count
#             else:
#                 distance[check[i]] =  min(count,distance[check[i]])
#         else:
#             bfs(graph[check[i]],count,distance)
#     return check,distance
#
# if len(graph[x])  == 0 :
#     print(-1)
#
# else:
#     check = graph[x]
#     count = 0
#     check,distance = bfs(check,count,distance)
#
# print(distance)
#
#
#
#
#
# 구현이 너무 오래 걸림 , count 맞추는데 시간 다씀 .




# #도시 , 도로 , 거리 정보, 출발 도시
from collections import  deque
n,m,k,x = map(int,input().split())

# graph
graph = [[] for _ in range(n+1)]

# get all road info ,
for _ in range(m) :
    a,b = map(int,input().split())
    graph[a].append(b)


# 모든 도시 최단 거리 초기화
distance = [-1]*(n+1)
distance[x] = 0 # 출발도시까지 거리는 0 으로 설정
# distance 배열을 적극적으로 사용한다.


q = deque([x])
while q:
    now = q.popleft()
    for next_node in graph[now]:
        if distance[next_node] == -1 :
            distance[next_node] =distance[now] + 1
            q.append(next_node)

# 최단 거리가 k 인 모든 도시의 번호를 오름 차순으로 출력
for i in range(1,n+1):
    if distance[i] == k:
        print(i)
        check = True

if check == False :
    print(-1)






