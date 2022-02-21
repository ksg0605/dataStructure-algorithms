# [알고리즘] 6. Sequential Search : 순차탐색 (Java)

> 순차 탐색 혹은 선형 검색 알고리즘은 리스트에서 찾고자 하는 값을 맨 앞에서부터 끝까지 차례대로 찾아 가는 알고리즘이다.

## 생각한 로직

1. 리스트의 처음부터 끝까지 탐색한다.
2. 찾는 값이 있으면 인덱스를 리턴
3. 없다면 -1을 리턴

## 코드 구현 (Java)

```java
package algorithms.search;

import java.util.ArrayList;

public class SequentialSearch {
    public Integer searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println("testData");
        System.out.println(testData);

        SequentialSearch sequentialSearch = new SequentialSearch();
        System.out.println(sequentialSearch.searchFunc(testData, 6));
    }
}

```

## 고민한 부분

- 완전 기초에 해당하는 부분.