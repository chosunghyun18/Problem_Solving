# Godl mine

# make  in 2 , 3
# 1 2 3
# 4 5 6

for t in range(int(input())) :
    n ,m = map(int,input().split())
    array = list(map(int,input().split()))

    #  make dp table
    dp = []
    index = 0
    for i in range(n):
        dp.append(array[index:index+m])
        index += m

    print(dp)
    #find startting poiint in max value
    value = 0
    startPoint = 0
    for i in range(n):
        if(dp[i][0] >value) :
            value = dp[i][0]
            startPoint = i
    print(startPoint,value) # init starting  pioint in value and index

    output = [] # get total value in output  # greedy case in choose the best



def checkPoint(point,n,m):
    # check out of index
    if point[0]  > m or point[1]  >  n or point[1]  <=1 :
        return False








