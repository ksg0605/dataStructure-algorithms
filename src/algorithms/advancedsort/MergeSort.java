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
