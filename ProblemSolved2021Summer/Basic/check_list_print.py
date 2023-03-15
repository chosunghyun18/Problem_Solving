"""
검정한는 리스트의 숫자가 1 이면출력을 한다

출력 형식 0 이 아닌 숫자를 제외하고 배열로 출력 




"""




A = [3,11,2,4,5]
A.sort()
x = [1]*len(A)
print([A[i] for i in range(len(x)) if x[i]])




A = [3,11,2,4,5]
A.sort()
x = [1]*len(A)
x[0] = 0
print([A[i] for i in range(len(x)) if x[i]])





A = [3,11,2,4,5]
A.sort()
x = [1]*len(A)
x[2] = 0
print([A[i] for i in range(len(x)) if x[i]])
