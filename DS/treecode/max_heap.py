#  make min heap
class Heap:
        def __init__(self, L=[]):
                self.A = L
                self.make_heap()

        def __str__(self):
                return str(self.A)

        def __len__(self):
                return len(self.A)

        def heapify_down(self, k, n):
                #n =  number of heap
                # A[k]  성질 위배시 밑으로

                while 2 * k + 1 < n:  # leaf node 전까지
                        L, R = 2 * k + 1, 2 * k + 2
                        if L < n and self.A[L] > self.A[k]:
                                m = L
                        else:
                                m = k

                        if R < n and self.A[R] > self.A[m]:
                                m = R

                        if m != k:  # A[k]가 최대값이 아니라면 힙 성질 위배
                                self.A[k], self.A[m] = self.A[m], self.A[k]
                                k = m
                        else:
                                break

        def make_heap(self):
                n = len(self.A)
                for k in range(n-1//2-1 ,-1,-1):
                        self.heapify_down(k,n)  #뒤에서 부터 리스트를 올라간다

        def heap_sort(self):
                n = len(self.A)
                for k in range(n - 1, -1, -1):
                        self.A[0], self.A[k] = self.A[k], self.A[0]
                        n = n - 1
                        self.heapify_down(0, n)

L = [int(x) for x in input().split()]
# L = [61, 86 ,17, 31, 2, 81, 19, 0 ,62, 49, 91, 35, 28, 68, 36, 69, 36, 32, 77, 33]
H = Heap(L)
H.heap_sort()
print(H)
