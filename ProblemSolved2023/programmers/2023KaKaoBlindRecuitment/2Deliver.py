def solution(cap, n, deliveries, pickups):
    deliveries.reverse()
    pickups.reverse()

    answer = 0

    have_to_deli = 0
    have_to_pick = 0

    for i in range(n):
        have_to_deli += deliveries[i]
        have_to_pick += pickups[i]

        while have_to_deli > 0 or have_to_pick > 0:
            have_to_deli -= cap
            have_to_pick -= cap
            answer += (n - i) * 2

    return answer





#Test 1
print(solution(4,5,[1, 0, 3, 1, 2],[0, 3, 0, 4, 0]))

# Test 2
print(solution(2,7,[1, 0, 2, 0, 1, 0, 2],[0, 2, 0, 1, 0, 2, 0]))