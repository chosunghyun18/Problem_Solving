
#얕은 복사 
sample = [[1,2],[1,3],[2,2],[1,2]]
c_sample = sample[:]
c_sample[0][0] = 14

print(sample) 
print(c_sample)


#참조 복사 - 완전히 같은 객체임
sample = [[1,2],[1,3],[2,2],[1,2]]
c_sample = sample
c_sample[0][0] = 14
print()
print(sample) 
print(c_sample)


import copy
#깊은 복사 ? 
sample = [[1,2],[1,3],[2,2],[1,2]]
c_sample = copy.deepcopy(sample)
c_sample[0][0] = 14
print()
print(sample) 
print(c_sample)