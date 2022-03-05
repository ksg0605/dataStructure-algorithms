# [알고리즘] 1. Bubble Sort : 버블 정렬 (Java)
> 버블 정렬은 이웃한 두 요소의 대소 관계를 비교하여 교환을 반복한다.

![버블정렬](https://upload.wikimedia.org/wikipedia/commons/3/37/Bubble_sort_animation.gif)

## 알고 가기
- 두 요소를 비교하여 큰 수를 뒤로 가도록 한다.
- 처음부터 끝까지 한번 반복하면 마지막 숫자는 가장 큰 수

## 코드
```java
package algorithms.basicsort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index ++) {
          boolean isSwap = false;

          for (int index2 = 0; index2 < dataList.size() - 1 - index; index2 ++) {
              if (dataList.get(index2) > dataList.get(index2 + 1)) {
                  Collections.swap(dataList, index2, index2 + 1);
                  isSwap = true;
              }
          }
          if (!isSwap) {
              break;
          }
      }
      return dataList;
    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 100 ; i ++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println("TestData : " + testData);
        bubbleSort.sort(testData);
        System.out.println("SortedData : " + testData);
    }


}
```

## 고민한 부분
- 두 번째 루프를 도는 부분에서 한 바퀴를 비교하고 다음번 비교에서 인덱스를 하나 빼주는 작업에서 고민

### 해결
```java
for (int index2 = 0; index2 < dataList.size() - 1 - index; index2 ++) {
              if (dataList.get(index2) > dataList.get(index2 + 1)) {
                  Collections.swap(dataList, index2, index2 + 1);
                  isSwap = true;
              }
          }
```
- 끝까지 비교하면, 비교 회차를 빼주어 다음 회차에서 비교 횟수를 줄인다.
- dataList.size() - 1 - index의 이유