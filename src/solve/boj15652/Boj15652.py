import sys

n, m = map(int, sys.stdin.readline().split(' '))
selected = [0 for _ in range(m)]
used = [0 for _ in range(n + 1)]

def rec_func(k):
  # 탐색 끝남
  if k == m:
    for x in selected:
      sys.stdout.write(str(x) + ' ')
    sys.stdout.write('\n')
  # 탐색 안끝남
  else:
    start = 1 if k == 0 else selected[k - 1]
    for candidate in range(start, n+1):
      selected[k] = candidate
      rec_func(k + 1)
      selected[k] = 0

rec_func(0)
