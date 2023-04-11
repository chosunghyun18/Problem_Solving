import ProblemSolved2023.boj.simulation.tile1388 as call

data = """
6 9
-||--||--
--||--||-
|--||--||
||--||--|
-||--||--
--||--||-
"""

def runner(data) :
        test_case = data.strip().split('\n')
        call.solution(test_case)

runner(data)







