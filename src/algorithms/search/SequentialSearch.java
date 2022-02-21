package algorithms.search;

import java.util.ArrayList;

/**
 * packageName            : algorithms.search
 * fileName              : SequentialSearch
 * author                : sunkyu
 * date                  : 2022/02/21
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/21           sunkyu             최초 생성
 */
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
