# # Godl mine
#
# # make  in 2 , 3
# # 1 2 3
# # 4 5 6
#
# for t in range(int(input())) :
#     n ,m = map(int,input().split())
#     array = list(map(int,input().split()))
#
#     #  make dp table
#     dp = []
#     index = 0
#     for i in range(n):
#         dp.append(array[index:index+m])
#         index += m
#
#     print(dp)
#     #  Clcluate dp table
#     for i in range(n):
#         for j in range(1,m):
#             current=dp[i][j]
#             # make  2 case two edge and  middle
#             if i == 0  :
#                 dp[i][j] = max(current + dp[0][j - 1], current + dp[0][j + 1], current + dp[0][j])
#             elif i == n :
#                 dp[i][j] = max(current + dp[n][m - 1], current + dp[n][j + 1], current + dp[n][j])
#             #bottom line
#             else:
#                 dp[i][j] = max(current + dp[i - 1][j - 1], current + dp[i - 1][j + 1], current + dp[i - 1][j])
#     for i in range(n) :
#         value = 0
#         if value < dp[i][m] :
#             value = dp[i][m]
#     # result
#     print(value)
#
#
#
# def checkPoint(point,n,m):
#     # check out of index
#     if point[0]  > m or point[1]  >  n or point[1]  <=1 :
#         return False
#
#
#
#
#



"""
Solution
"""
n = 3
m =5
def solv() :
    for j in range (1,m) :
        for i in range(n) :
            # in Case of from  left top
            if i == 0 :
                left_uP = 0
            else : #from same row
                left_uP = dp[i-1][j-1]

            # incase of from  left  down
            if i == n-1 :
             left_down = 0
            else :
                left_down = dp[i+1][j-1]

            # incase from left
            left = dp[i][j-1]
            dp[i][j] = dp[i][j] + max(left_down,left_uP,left)
    re = 0
    for i in range(n):
        re = max(re,dp[i][m-1])






