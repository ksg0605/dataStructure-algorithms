import sys
from tkinter.tix import Tree

n, m = map(int, sys.stdin.readline().split(' '))
selected = [0 for _ in range(m)]
used = [0 for _ in range(n + 1)]

def rec_func(k):
  # 탐색이 끝남 (출력해줘야함)
  if k == m:
    for x in selected:
      sys.stdout.write(str(x) + ' ')
    sys.stdout.write('\n')
  
  # 탐색이 덜끝남
  else:
    isUsed = False;
    for x in used:
      if x == k:
        isUsed = True
      
