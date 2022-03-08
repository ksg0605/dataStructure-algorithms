'''
한 줄씩 탐색하는 것을 재귀로 돌리는것이 좋아보인다.
가로줄 col은 고를 필요 없어보임
퀸 세로row 바로 밑에, 대각선 바로 밑에를 제외하고 갈 곳이 있는가
가능한 줄이 없다면 continue하자
'''

import sys

n = int(sys.stdin.readline())
col = [0 for _ in range(n)]
ans = 0

def canAttack(r1, c1, r2, c2):
  if c1 == c2:
    return True
  if r1 - c1 == r2 - c2:
    return True
  if r1 + c1 == r2 + c2:
    return True
  return False

def recFunc(row):
  if row == n:
    global ans
    ans += 1
  else:
    for cand in range(n):
      possible = True
      for i in range(row):
        if canAttack(row, cand, i, col[i]):
          possible = False
          break

      if possible:
        col[row] = cand
        recFunc(row + 1)
        col[row] = 0

recFunc(0)
print(ans)