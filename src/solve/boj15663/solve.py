import sys

n, m = map(int, sys.stdin.readline().split(' '))
nList = sorted(list(map(int, sys.stdin.readline().split(' '))))

selected = [0 for _ in range(m)]
used = [0 for _ in range(n + 1)]

def rec_func(k):
  if k == m:
    for x in selected:
      sys.stdout.write(str(x) + ' ')
    sys.stdout.write('\n')
  else:
    lastCand = 0
    for cand in range(n):
      if used[cand] == 1 or lastCand == nList[cand]:
        continue
      lastCand = nList[cand]
      
      selected[k] = nList[cand]
      used[cand] = 1

      rec_func(k + 1)

      selected[k] = 0
      used[cand] = 0

rec_func(0)