

# chat gpt
import sys

f = sys.stdin.readline

n = int(f())

scores = []

for _ in range(n):
    name, *marks = f().split()
    scores.append((name, *map(int, marks)))

sort_one = sorted(scores, key=lambda score: (-score[1], score[2], -score[3], score[0]))

for name, *marks in sort_one:
    print(name)





# import sys
#
# f = sys.stdin.readline
#
# n = int(f())
#
# scores = []
#
# for _ in range(n):
#     scores.append(list(f().split()))
#
# sort_one = sorted(scores ,key=lambda score : score[1],reverse=True)
# # print(sort_one)
#
# start ,end = -1 , -1
# sort_two = sort_one[:]
# for i in range(n-1) :
#     if sort_one[i][1] == sort_one[i+1][1] :
#        if start == -1 :
#             start = i
#     else :
#         if start == -1 :
#             continue
#         else :
#             end = i
#             # sorting start  to end  put it again
#             tmp = sorted(sort_one[start:end+1],key=lambda score : score[2])
#             sort_two[start:end+1] = tmp
#             start, end = -1, -1
#             # make init again
# #check sorting incase end  4,4
#
# if start != -1 :
#     tmp = sorted(sort_one[start:-1+1], key=lambda score: score[2])
#     sort_two[start:-1+1] = tmp
#     # same sorting
# # print(sort_two)
#
#
# start ,end = -1 , -1
# sort_three = sort_two[:]
# for i in range(n-1) :
#     if sort_two[i][1] == sort_two[i+1][1] and sort_two[i][2] == sort_two[i+1][2] :
#        if start == -1 :
#             start = i
#     else :
#         if start == -1 :
#             continue
#         else :
#             end = i
#             # sorting start  to end  put it again
#             tmp = sorted(sort_two[start:end+1],key=lambda score : score[3],reverse=False)
#             sort_three[start:end+1] = tmp
#             start, end = -1, -1
#
#
# if start != -1 :
#     tmp = sorted(sort_two[start:-1+1], key=lambda score: score[3],reverse=False)
#     sort_three[start:-1+1] = tmp
#
# #
# #
# # for x in sort_three :
# #     print(x)
#
#
# start ,end = -1 , -1
# sort_four = sort_three[:]
# for i in range(n-1) :
#     if sort_three[i][1] == sort_three[i+1][1] and sort_three[i][2] == sort_three[i+1][2] and sort_three[i][3] == sort_three[i+1][3] :
#        if start == -1 :
#             start = i
#     else :
#         if start == -1 :
#             continue
#         else :
#             end = i
#             # sorting start  to end  put it again
#             tmp = sorted(sort_three[start:end+1],key=lambda score : score[0][0])
#             sort_four[start:end+1] = tmp
#             start, end = -1, -1
#
#
# if start != -1 :
#     tmp = sorted(sort_three[start:-1+1], key=lambda score: score[0][0])
#     sort_four[start:-1+1] = tmp
#
#
#
# # print(sort_four)
# print("-------------")
# print("-------------")
#
#
# for x in sort_three :
#     print(x)
#
#
# print("-------------")
# print("-------------")
# for x in sort_four :
#     print(x)
#
#
#
#
#
#
#
