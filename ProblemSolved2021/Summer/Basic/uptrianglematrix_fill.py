import pandas as pd



n = 6
p = [2,5,3,5,10,2,4]
c = [[0]*n for _ in range(n)] # 비용을 저장할 2차원 리스트 C 초기화
pf=pd.DataFrame(c)
print(pf)



nt =0
for x in range(n-1,-1,-1):
    print(x)
    nt+=1
    # x = 5
    for i in range(x):
        c[i][i+nt] = nt




pf=pd.DataFrame(c)
print(pf)
"""

c[0][1]       +1
c[1][2]
c[2][3]
c[3][4]
c[4][5] 
#             +2 
c[0][2]
c[1][3]
c[2][4]
c[3][5]
#          + 3
c[0][3]
c[0][4]
c[0][5] 

"""











