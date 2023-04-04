# Godl mine
# T  = number of test case

# N , m given




# make  in 2 , 3
# 1 2 3 4 5 6
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








