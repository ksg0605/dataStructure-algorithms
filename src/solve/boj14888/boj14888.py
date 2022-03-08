import sys

# 1. 입력
n = int(sys.stdin.readline())
nList = list(map(int, sys.stdin.readline().split(' ')))
operators = list(map(int, sys.stdin.readline().split(' ')))
max = -1e9 
min = 1e9 

# 3. 계산을 도와주는 함수
def calculator(operand1, operator, operand2):
  if operator == 0:
    return operand1 + operand2
  if operator == 1:
    return operand1 - operand2
  if operator == 2:
    return operand1 * operand2
  if operator == 3:
    if operand1 < 0:
      return -((-operand1) // operand2)
    else:
      return operand1 // operand2

# 2. 완전탐색 (재귀를 활용한다.)
def recFunc(k, value):
  if k == n-1:
    global max, min
    max = max if max > value else value
    min = min if min < value else value
  else:
    for cand in range(4):
      if operators[cand] >= 1:
        operators[cand] -= 1
        recFunc(k + 1, calculator(value, cand , nList[k + 1]))
        operators[cand] += 1

recFunc(0, nList[0])
print(max)
print(min)