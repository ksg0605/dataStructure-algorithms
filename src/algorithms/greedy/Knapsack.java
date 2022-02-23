package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * packageName            : algorithms.greedy
 * fileName              : Knapsack
 * author                : sunkyu
 * date                  : 2022/02/23
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/23           sunkyu             최초 생성
 */
public class Knapsack {
    public void solve(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction;

        Arrays.sort(objectList, (objectItem1, objectItem2) -> (objectItem2[1] / objectItem1[0]) - (objectItem1[1] / objectItem1[0]));

        for (Integer[] index : objectList) {
            if ((capacity - (double) index[0]) > 0) {
                totalValue += (double) index[1];
                capacity -= (double) index[0];
                System.out.println("무게: " + index[0] + " 가치: " + index[1]);
            } else {
                fraction = capacity / (double) index[0];
                totalValue += (double) index[1] * fraction;
                System.out.println("무게: " + index[0] + " 가치: " + index[1] + " 비율: " + fraction);
                break;
            }
        }
        System.out.println("총 " + totalValue);
    }

    public static void main(String[] args) {
        Integer[][] dataList = {
                {10, 10},
                {15, 12},
                {20, 10},
                {25, 8},
                {30, 5}
        };

        Knapsack knapsack = new Knapsack();
        knapsack.solve(dataList, 30.0);
    }
}
