# [알고리즘] 5. Quick Sort : 퀵 정렬 (Java)

> 퀵 정렬은 기준점이 되는 피벗을 하나 정하고, 피벗을 기준으로 큰 값은 오른쪽, 작은 값은 왼쪽에 정렬하는 방법이다.

![QuickSort](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Sorting_quicksort_anim.gif/220px-Sorting_quicksort_anim.gif)

## 생각한 로직

1. 배열의 맨 앞을 pivot 으로 설정한다.
2. pivot 보다 작은 수를 left 에 저장
3. pivot 보다 큰 수를 right 에 저장
4. 2, 3에서 재귀 수행
5. 배열들을 합친다.

> 구현은 생각보다 쉽다.
> 합병정렬이랑 비슷해서 그런걸지도?

## 코드 구현 (Java)

```java
package algorithms.advancedsort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return dataList;
        }
        Integer pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if (pivot < dataList.get(index)) rightArr.add(dataList.get(index));
            else leftArr.add(dataList.get(index));
        }

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(this.sort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        System.out.println("TestData");
        System.out.println(testData);
        QuickSort quickSort = new QuickSort();
        System.out.println("sortedData");
        System.out.println(quickSort.sort(testData));
    }

}

```

## 고민한 부분

- 처음에는 subList()를 써야 하나 고민했지만 그냥 right, left로 편하게 구현했다.

