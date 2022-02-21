package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * packageName            : algorithms.search
 * fileName              : BinarySearch
 * author                : sunkyu
 * date                  : 2022/02/21
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/21           sunkyu             최초 생성
 */
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
