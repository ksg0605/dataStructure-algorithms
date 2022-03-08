import sys

n, s = map(int, sys.stdin.readline().split(' '))
nList = list(map(int, sys.stdin.readline().split(' ')))
result = 0

def recFunc(k, sum):
  global n, s, nList, result
  if k == n:
    if sum == s:
      result += 1
    
  else:
    recFunc(k + 1, sum + nList[k])
    recFunc(k + 1, sum)

recFunc(0, 0)
if s == 0:
  result -= 1

print(result)