import sys
input = sys.stdin.readline

C, N = map(int, input().split())
DP = [[0] * (C+1)]* N
idx = 0
for _ in range(N):
    budget, customer = map(int, input().split())
    current = 0
    tmp = 1
    for i in range(1, C):
        while current < i:
            tmp *= customer