
import sys
n,count = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))




def solv(count) :
    for j in range(n-1,-1,-1):
        max = -1
        index =0
        for i in range(j):
            if array[i] > max:
                max = array[i]
                index  = i

        if array[j] < max:
            count -= 1
            array[j] , array[index] = array[index] , array[j]

            if count == 0 :

                return print( array[index],array[j] )

    return print(-1)


solv(count)


