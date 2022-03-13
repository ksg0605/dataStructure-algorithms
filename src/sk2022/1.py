def solution(money, costs):
    answer = 0
    coinList = [1, 5, 10, 50, 100, 500]
    detail = {}

    for i in range(6):
        detail[coinList[i]] = coinList[i]/costs[i]

    detail = sorted(detail.items(), key=lambda x: x[1], reverse=True)

    for i in range(6):
        if money == 0:
            break
        num = money//detail[i][0]
        money -= num*detail[i][0]
        answer += num*(int)(detail[i][0]/detail[i][1])

    return answer