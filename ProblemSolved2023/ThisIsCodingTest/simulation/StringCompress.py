"""

make Sting compress


"""
data = input()
# put in loop


def solutions(s) :
    number = len(s)
    answer = number
    for step in range(1,number // 2 + 1 ) :
        compressed = ""
        prev =s[0:step]
        count = 1
        for x in range(step,number,step):
            if prev == s[x:step+1] :
                count += 1
            else :
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[x:step+x]
                count = 1

        # find min len
        compressed += str(count) + prev if count >= 2 else prev
        answer = min(answer,len(compressed))
    return answer