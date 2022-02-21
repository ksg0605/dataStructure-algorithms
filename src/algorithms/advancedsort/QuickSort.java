package algorithms.advancedsort;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName            : algorithms.advancedsort
 * fileName              : QuickSort
 * author                : sunkyu
 * date                  : 2022/02/21
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/21           sunkyu             최초 생성
 */
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
