from random import randrange
import sys

n, m = map(int, sys.stdin.readline().split(' '))

selected = [0 for _ in range(m)]
used = [0 for _ in range(n + 1)]

def rec_func(k):
  # 찾기 끝
  if k == m:
    for x in selected:
      sys.stdout.write(str(x) + ' ')
    sys.stdout.write('\n')
  else:
    for candidate in range(1, n+1):
      if used[candidate]:
        continue
      selected[k] = candidate
      used[candidate] = 1
      rec_func(k + 1)
      selected[k] = 0
      used[candidate] = 0

rec_func(0)