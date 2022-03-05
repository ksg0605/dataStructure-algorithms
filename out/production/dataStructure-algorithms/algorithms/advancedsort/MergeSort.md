# [알고리즘] 4. Merge Sort : 병합 정렬 (Java)
> 병합 정렬(합병 정렬)은  배열을 더 이상 나누어질 수 없을 때까지 쪼개고, 쌍으로 비교하여 정렬하는 알고리즘이다.

![MergeSort](https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Merge-sort-example-300px.gif/220px-Merge-sort-example-300px.gif)

## 생각한 로직
1. 배열을 반으로 계속 쪼갠다.
2. 각 부분 배열을 합치면서 정렬한다. 

> 간단해 보이지만 생각보다 구현에서 신경써줄것들이 좀 있었다.

## 코드 구현 (Java)
```java
package algorithms.advancedsort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> splitArray(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        else {
            ArrayList<Integer> leftList = new ArrayList<Integer>();
            ArrayList<Integer> rightList = new ArrayList<Integer>();

            int flag = dataList.size() / 2;

            leftList = splitArray(new ArrayList<Integer>(dataList.subList(0, flag)));
            rightList = splitArray(new ArrayList<Integer>(dataList.subList(flag, dataList.size())));

            return this.sort(leftList, rightList);
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;

        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) < rightList.get(rightPoint)) {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
            else {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            }
        }

        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random()*100));
        }
        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.splitArray(testData));
    }
}

```

## 고민한 부분
- splitArray() 메소드에서 subList() 를 사용하였다.  
원래는 아래 코드와 같이 구현하고 머리좀 썼네? 하고 있었지만..  
막상 테스트해보니 홀수 짝수를 생각해주지 않아서 맨 끝이 생략되는 경우가 종종 있었다.

```java
for (int i = 0; i < flag; i ++) {
    leftList.add(dataList.get(i));
    rightList.add(dataList.get(flag + i));
} 
```