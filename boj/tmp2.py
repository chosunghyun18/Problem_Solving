


array =[[0, 1, 2, 3, 4, 5], [1, 0, 2, 3, 4, 5], [1, 2, 0, 3, 4, 5], [1, 2, 3, 0, 4, 5], [1, 2, 3, 4, 0, 5], [1, 2, 3, 4, 5, 0]]
left = [[4, 5, 6], [3, 5, 6], [3, 4, 6], [3, 4, 5], [2, 5, 6], [2, 4, 6], [2, 4, 5], [2, 3, 6], [2, 3, 5], [2, 3, 4]]
right = [[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 2, 6], [1, 3, 4], [1, 3, 5], [1, 3, 6], [1, 4, 5], [1, 4, 6], [1, 5, 6]]




for arr in range(len(right)):
    value = 0
    for i in range(len(right[0])):
        for j in range(i+1,len(right[0])):
            print(left[arr][i],left[arr][j])
            print(left[arr][j], left[arr][i])
            print(right[arr][i], right[arr][j])
            print(right[arr][i], right[arr][j])

            # print(left[arr][i] - 1, left[arr][j] - 1)
            # print(array[left[arr][i] - 1][left[arr][j] - 1], array[left[arr][j] - 1][left[arr][i] - 1])
            # print(array[right[arr][i] - 1][right[arr][j] - 1], array[right[arr][j] - 1][right[arr][i] - 1])
            up = array[right[arr][i] - 1][right[arr][j] - 1] + array[right[arr][j] - 1][right[arr][i] - 1]
            down = array[left[arr][i] - 1][left[arr][j] - 1] + array[left[arr][j] - 1][left[arr][i] - 1]
            tmp=abs(up - down)

            print("tmp value", tmp)
            value += tmp

    print("total v",value)
    if min > tmpv:
        min = tmpv
    print(".,.,.,.,.,")














