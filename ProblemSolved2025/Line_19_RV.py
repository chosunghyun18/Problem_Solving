from collections import deque

def solve(cony_position: int, brown_position: int) -> int:
    time = 0
    visit = [[False] * 2 for _ in range(200001)]
    queue = deque()
    
    queue.append((brown_position, 0))
    visit[brown_position][0] = True

    while True:
        cony_position += time
        if cony_position > 200000:
            return -1
        if visit[cony_position][time % 2]:
            return time
        
        for _ in range(len(queue)):
            current_position, current_time = queue.popleft()
            next_time = (current_time + 1) % 2
            
            for new_position in (current_position - 1, current_position + 1, current_position * 2):
                if 0 <= new_position <= 200000 and not visit[new_position][next_time]:
                    visit[new_position][next_time] = True
                    queue.append((new_position, next_time))
                    
        time += 1