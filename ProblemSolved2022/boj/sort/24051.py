
import sys
n,count = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))




def solv(count) :
    for j in range(1,n):
        i = j -1
        index = i+1
        # print(array)
        if i >= 0  and array[i] >array[i+1] :
            tmp = array[index]
            while( i >= 0  and array[i] >array[i+1]) :
                    count -= 1

                    array[i+1] = array[i]
                    array[i] = tmp
                    if count == 0 :
                        # print(array)
                        return print(array[i+1])
                    i-=1

            count -= 1
            if count == 0:
                # print(array)
                return print(tmp)

    return print(-1)


solv(count)


