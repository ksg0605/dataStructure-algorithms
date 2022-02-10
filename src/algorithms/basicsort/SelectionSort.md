# [알고리즘] 1. Selection Sort : 선택 정렬 (Java)
> 선택 정렬은 최솟값을 찾아 맨 앞으로 보내는 알고리즘이다.
>
![SelectionSort](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

## 생각한 로직
1. 맨 앞의 값을 최소값으로 저장한후 끝까지 탐색한다.
2. 탐색하던 중 맨 앞의 값보다 작은 값이 있다면 최소값에 저장한다.
3. 한번 탐색이 완료되면 저장된 최소값을 맨 앞의 값과 바꾼다.
4. 맨 앞 + 1을 맨 앞 인덱스로 잡고 다시 반복한다.

## 코드 구현 (Java)
```java
package algorithms.basicsort;

import java.util.ArrayList;
import java.util.Collections;
public class SelectionSort {
    int minIndex;
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int round = 0; round < dataList.size() - 1; round ++) {
            minIndex = round;
            for (int index = round + 1; index < dataList.size() - 1; index ++) {
                if (dataList.get(minIndex) > dataList.get(index)) {
                    minIndex = index;
                }
            }
            Collections.swap(dataList, round, minIndex);
        }
        return dataList;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100 ; i ++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println("TestData : " + testData);
        selectionSort.sort(testData);
        System.out.println("SortedData : " + testData);
    }
}


```

## 고민한 부분
- 처음에 두 번째 루프문 안에서 swap() 을 진행하였는데
- 공간복잡도가 너무 높아지는것 같아
- 인덱스로만 저장해두기로 하고 두번째 루프 후에 swap() 을 진행하였다.
