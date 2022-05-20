from collections import deque
import copy
import sys
input = sys.stdin.readline

global mx, my
mx = [1, 0, -1, 0]
my = [0, 1, 0, -1]

global lab, answer
answer = 0
lab = []
virus = []

def bfs(virus):
    q = deque(virus)
    labs = copy.deepcopy(lab)
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            tx = x + mx[i]
            ty = y + my[i]

            if tx < 0 or tx >= N or ty < 0 or ty >= M:
                continue
            if labs[tx][ty] == 0:
                labs[tx][ty] = 2
                q.append((tx, ty))
    
    global answer

    result = 0
    for i in range(N):
        result += labs[i].count(0)
    answer = max(answer, result)
    
def pprint(arr):
    for line in arr:
        print(line)

def sol(cnt):
    if cnt == 3:
        bfs(virus)
        return

    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                sol(cnt + 1)
                lab[i][j] = 0

N, M = map(int, input().split())

for i in range(N):
    cnt = 0
    tmp = list(map(int, input().split()))
    if 2 in tmp:
        while cnt < tmp.count(2):
            virus.append((i, tmp.index(2, cnt)))
            cnt += 1
    lab.append(tmp)

sol(0)
print(answer)