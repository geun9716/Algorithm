
import pprint as pp
from collections import deque
import sys
input = sys.stdin.readline

mx = [-1, -1, 0, 0, 1, 1]
my1 = [-1, 0, -1, 1, -1, 0]
my2 = [0, 1, -1, 1, 0, 1]

def isInside(r, c):
    for i in range(6):
        row = r + mx[i]
        if r % 2 == 0: #Even
            col = c + my2[i]    
        else: #Odd
            col = c + my1[i]
        if row < 0 or H <= row or col < 0 or W <= col:
            return False
        else:
            if not G[row][col] == 1:
                return False
    return True

def bfs(start, cnt):
    q = deque([start])
    rounds = 0
    while q:
        x, y = q.popleft()
        for i in range(6):
            row = x + mx[i]
            if x % 2 == 0: #Even
                col = y + my2[i]    
            else: #Odd
                col = y + my1[i]
            if 0 <= row < H and 0 <= col < W:
                if not visited[row][col]:
                    if G[row][col] == 1:
                        visited[row][col] = True
                        q.append((row, col))
                    elif not isInside(row, col):
                        rounds += 1
            else:
                rounds += 1

    return rounds
W, H = map(int, input().split())
G = [list(map(int, input().split())) for _ in range(H)]
visited = [[False] * W for _ in range(H)]

cnt = 2
starts = []
answer = 0
for i in range(H):
    for j in range(W):
        if not visited[i][j] and G[i][j] == 1:
            visited[i][j] = True
            tmp = bfs((i, j), cnt)
            print(tmp)
            answer += tmp
            cnt += 1

pp.pprint(G)
pp.pprint(visited)
print(answer)
