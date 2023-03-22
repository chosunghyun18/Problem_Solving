# # # import sys
# # # brutal
# # # f = sys.stdin.readline
# # #
# # # n = int(f())
# # #
# # # house = list(map(int,f().split())) # get index of house
# # # house.sort()
# # #
# # #
# # # n  = house[-1]
# # #
# # # distance  = [-1] *(house[-1]+1)
# # #
# # #
# # # # print(house)
# # #
# # # for now in range(1,n+1):
# # #     result = 0
# # #     for hx in house:
# # #         result += abs(now - hx)
# # #
# # #     distance[now] = result
# # #
# # #
# # # ans = int(1e9)
# # # index = 0
# # # for i in range(1,len(distance)) :
# # #     x = distance[i]
# # #     if ans  > x  :
# # #         ans = x
# # #         index = i
# # #
# # # print(index)
# #
#
#
#
#
#
# import sys
# f = sys.stdin.readline
# house = list(map(int,f().split())).sort()
#
#
# total = house[-1]
#
# node = house[-1]*(total+1)
#
# visit = node[:]
# #[-1,-1,,,,,,,-1]
#
# start = total // 2
#
# right = 0
# rc = 0
#
# left = 0
# lc = 0
# first_right = 0
# for x in house:
#     if  x <= start:
#         left+=abs(x-start)
#         lc += 1
#         last_left = x
#     else:
#         right += abs(x - start)
#         rc += 1
#         if first_right == 0:
#             first_right = x
#
# resultRoot = (left,right) # root
# result = left+right
# count = (lc,rc)
# node[start] = result
# #check right  -> start +1
#
# def bfs(rc,lc,start,left,right,result,first_right,last_left,node) :
#
#     if rc >  lc :
#         start += 1
#         left += lc
#         right -= rc
#         result =  left +right
#         if first_right == start:
#             last_left = first_right
#
#     else :
#         start -= 1
#         left -= lc
#         right += rc
#         result = left + right
#         if last_left == start:
#             first_right = last_left
#     node[start] = result
#
#     if visit[start] == -1 :
#         bfs(rc, lc, start, left, right, result, first_right, last_left,node)
#
#     else :
#         return rc, lc, start, left, right, result, first_right, last_left,node
#
#

n = int(input())
data = list(map(int,input().split()))
data.sort()
print(data[(n-1)//2])


