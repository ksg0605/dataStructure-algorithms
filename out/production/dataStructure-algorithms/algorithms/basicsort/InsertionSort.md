# [알고리즘] 3. Insertion Sort : 삽입 정렬 (Java)
> 삽입 정렬은 자신을 기준으로 자신보다 앞에 있는 숫자들과 비교하여 자신의 자리를 찾아 넣는 알고리즘이다.

![InsertionSort](https://upload.wikimedia.org/wikipedia/commons/e/ea/Insertion_sort_001.PNG)

## 생각한 로직
1. 비교는 두번째 인덱스부터 시작한다.
2. 기준 인덱스 값 바로 앞 데이터부터 비교를 시작하여 더 작으면 교체한다.
3. 배열의 처음부터 끝까지 비교하는 반복문이 필요하고
4. 기준 인덱스부터 맨 앞까지 비교하는 반복문이 필요하다.
5. 비교 후 기준 인덱스 값이 더 작으면 교체한다.


## 코드 구현 (Java)
```java
package algorithms.basicsort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index ++) {
            for (int index2 = index + 1; index2 > 0; index2 --) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                }
                else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        InsertionSort insertionSort = new InsertionSort();
        testData = insertionSort.sort(testData);
        System.out.println(testData);
    }
}

```

## 고민한 부분
- 처음엔 인덱스 값만 저장 후 마지막에 값을 바꿔주려고 하였는데 

| 바뀔 위치 | a | a | a | 원래 위치 |  
|---|----|----|---|---|

- a 들의 인덱스 값을 하나씩 + 1 해주는 것보다 계속해서 swap() 해 주는것이 더 구현이 쉬울것 같았다.