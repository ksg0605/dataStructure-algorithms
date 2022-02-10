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
