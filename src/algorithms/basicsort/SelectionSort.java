package algorithms.basicsort;

import java.util.ArrayList;
import java.util.Collections;
public class SelectionSort {
    int minIndex;
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int round = 0; round < dataList.size() - 1; round ++) {
            minIndex = round;
            for (int index = round + 1; index < dataList.size() - 1; index ++) {
                if (dataList.get(minIndex) > dataList.get(index)) {
                    minIndex = index;
                }
            }
            Collections.swap(dataList, round, minIndex);
        }
        return dataList;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100 ; i ++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println("TestData : " + testData);
        selectionSort.sort(testData);
        System.out.println("SortedData : " + testData);
    }
}

