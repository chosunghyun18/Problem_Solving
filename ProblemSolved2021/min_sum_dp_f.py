def solve(A):
    if len(A) == 1:
        return A[0]
    # 초기값 설정
    que_v = []
    que_s = []
    que_v.append(A[0])
    que_s.append(1)  # 크
    min_v = A[0]
    result = A[0]
    dp = A[0]
    k = 0

    for i in range(1, len(A)):
        k = 0
        print("    ")
        print("------  i ------- ", i)
        print("---------- A [i]:",A[i])
        print("---------- min_v",min_v)
        print("---------- q_v", que_v)
        print("---------- q_v[-1]", que_v[-1])
        print("R:", result)
        print("dp:",dp)
        print("    ")

        if A[i] < min_v:
            print("in before min", result)
            print("in before min ", A[i] * (i + 1))
            result += A[i] * (i + 1)
            print("in after min", result)
            dp = A[i] * (i + 1)
            print("this is result of 1 ", result)
            que_v = []
            que_v.append(A[i])
            que_s = []
            que_s.append(i + 1)
            min_v = que_v[0]
            print("min", min_v)
            print("this is q 1 ", que_v)


        elif A[i] > que_v[-1]:

            print("dp 1 ", dp)
            print("this is result before 2", result)
            result += (dp + A[i])
            dp = (dp + A[i])
            print("dp 2 ", dp)
            print("this is result of q  2", que_v)
            que_v.append(A[i])
            que_s.append(1)
            print("this is result of q  3", que_v)
            print("this is result 2", result)


        else:  # A[i] > min_ v
            cnt = 0
            v = que_v[0]
            v_s = que_s[0]

            # v,v_i  is  minimum
            while cnt != i + 1:

                if cnt == i:  # 1 개 남은 경우
                    que_v.append(A[i])
                    que_s.append(1)
                    result += A[i]
                    k = 0
                    cnt += 1
                    print("this is i+1", i + 1)
                    print("this is cnt", cnt)

                else:
                    # v 는  가지는 것중에 최소 가 아 님
                    if A[i] < que_v[k]:

                        size = (i + 1) - cnt
                        result += A[i] * (size)
                        print("this is result", result)
                        cnt += (size)


                        # 큐를  수정     현제 v 는   K 값
                        que_v[k] = A[i]
                        que_s[k] = size
                        que_v = que_v[0:k+1]
                        que_s = que_s[0:k+1]
                        k = 0

                    else:  # v< A[i]
                        print("L:  this is q", que_v)
                        print("L: this is  q[k]", que_v[k])
                        print("L: this is  size[k]", que_s[k])

                        print("L:  B R", result)
                        result += (que_v[k] * (que_s[k]))
                        print("L:  R",result)

                        print("L : cnt B",cnt)
                        cnt += que_s[k]
                        print("L : cnt", cnt)

                        if cnt != i:  # 1 개 남은 경우  다음 숫자와 비교를 위해 넘김
                            k = k + 1
            dp = 0
            for x in range(len(que_v)):
                dp += que_v[x] * que_s[x]

    return result


#  -1 3 4 -4 2 6 5
# A = [int(x) for x in input().split()]
A =[0,1,2,3,4,-4,-5,-6,12,9,8,7,2]

print(solve(A))

# 0 1 2 3 4 -4 -5 -6 12 9 8 7 2
