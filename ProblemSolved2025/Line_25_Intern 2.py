
def solution(code):
   def get_pattern(given_string):
       pattern = ""
       for c in given_string:
           if not c.isalpha():
               pattern +='[N]'
           else:
               pattern +='[A]'
       return pattern
   
   def get_alpha(given_string):
       return ''.join(c for c in given_string if c.isalpha())
   
   gift_code_pattern_info = {}
   
   for c in code:
       pattern = get_pattern(c)
       alpha = get_alpha(c)
       key = (pattern,alpha)
       gift_code_pattern_info[key] = gift_code_pattern_info.get(key,0)+1
   
   answer = 0
   for g_value in gift_code_pattern_info.values():
       if g_value >1 :
           answer += g_value -1
   
   return answer

'''
- ["A1B2", "A2B3", "C1D2"]
    - "A1B2": 패턴="anan", 알파벳="AB"
    - "A2B3": 패턴="anan", 알파벳="AB"
    - "C1D2": 패턴="anan", 알파벳="CD"
    - 그룹: {("anan", "AB"): 2, ("anan", "CD"): 1}
    - 중복: 1 ✓
- ["123", "456", "789"]
    - 모두 패턴="nnn", 알파벳=""
    - 그룹: {("nnn", ""): 3}
    - 중복: 2 ✓
- ["2AB2", "A2B3", "C1D2"]
    - "2AB2": 패턴="naan", 알파벳="AB"
    - "A2B3": 패턴="anan", 알파벳="AB"
    - "C1D2": 패턴="anan", 알파벳="CD"
    - 그룹: {("naan", "AB"): 1, ("anan", "AB"): 1, ("anan", "CD"): 1}
    - 중복: 0 ✓
- ["AAA057", "AAA031", "BBB777"]
    - "AAA057": 패턴="aaannn", 알파벳="AAA"
    - "AAA031": 패턴="aaannn", 알파벳="AAA"
    - "BBB777": 패턴="aaannn", 알파벳="BBB"
    - 그룹: {("aaannn", "AAA"): 2, ("aaannn", "BBB"): 1}
    - 중복: 1 ✓
- ["A01", "A22", "A23", "43A", "BB1", "BB2"]
    - "A01": 패턴="ann", 알파벳="A"
    - "A22": 패턴="ann", 알파벳="A"
    - "A23": 패턴="ann", 알파벳="A"
    - "43A": 패턴="nna", 알파벳="A"
    - "BB1": 패턴="aan", 알파벳="BB"
    - "BB2": 패턴="aan", 알파벳="BB"
    - 그룹: {("ann", "A"): 3, ("nna", "A"): 1, ("aan", "BB"): 2}
    - 중복: 2 + 1 = 3 ✓
- ["1A1AA", "2B2BB", "3C3CC", "4D4DD", "56789"]
    - "1A1AA": 패턴="nanaa", 알파벳="AAA"
    - "2B2BB": 패턴="nanaa", 알파벳="BBB"
    - "3C3CC": 패턴="nanaa", 알파벳="CCC"
    - "4D4DD": 패턴="nanaa", 알파벳="DDD"
    - "56789": 패턴="nnnnn", 알파벳=""
    - 그룹: {("nanaa", "AAA"): 1, ("nanaa", "BBB"): 1, ("nanaa", "CCC"): 1, ("nanaa", "DDD"): 1, ("nnnnn", ""): 1}
    - 중복: 0 ✓
'''