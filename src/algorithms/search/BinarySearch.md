# [알고리즘] 7. BinarySearch : 이진탐색 (Java)

> 탐색할 리스트를 반으로 나누어 찾는 데이터가 있을만한 곳을 찾아낸다.

![BinarySearch](https://w.namu.la/s/94f20dfd1fedd870adb23dca8ff59636748661774ea02edd951c2e966ef96f06e82bbf207951e27f896df8e23c9d9060c301db5637e52044ef12c2cd6b1a638249be6705b67fcefe6cc7a9866db87ed8d5bafadd032089700a1759bb1caace22a26b593ccf26f9bab9138fbdf991adbc)

- 출처 : [나무위키](https://namu.wiki/jump/gH0yIwNDq63Hu3fiP9U21tAWkM%2BT%2Btr5D42OFuiXxFMxu3jDL38aVZh9ie1cK6%2BZ)

## 생각한 로직

1. 절반을 정하는 변수를 만든다.
2. 찾으려는 수가 절반보다 크면 우측을 탐색
3. 찾으려는 수가 절반보다 작으면 좌측을 탐색
4. 재귀로 반복한다.

## 코드 구현 (Java)

```java
package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {

        if (dataList.size() == 1 && dataList.get(0) == searchItem) {
            return true;
        }
        if (dataList.size() == 1 && dataList.get(0) != searchItem) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        Integer mid = dataList.size() / 2;

        if (dataList.get(mid) == searchItem) {
            return true;
        } else {
            if (dataList.get(mid) > searchItem) {
                return this.searchFunc(new ArrayList<>(dataList.subList(0, mid)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<>(dataList.subList(mid, dataList.size())), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        Collections.sort(testData);

        System.out.println("testData");
        System.out.println(testData);

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchFunc(testData, 2));
    }
}

```

## 고민한 부분

- 데이터 사이즈가 1이고 그 데이터가 찾으려는 값과 같을때
- 데이터 사이즈가 1이고 그 데이터가 찾으려는 값과 다를때
- 데이터 사이즈가 0일때
- 이러한 제약 기반들을 설정하는데서 아직은 부족함을 보인다.
- 더 많은 문제를 풀어볼 것.