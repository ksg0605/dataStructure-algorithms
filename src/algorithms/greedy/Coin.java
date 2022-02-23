package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * packageName            : algorithms.greedy
 * fileName              : Coin
 * author                : sunkyu
 * date                  : 2022/02/23
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/23           sunkyu             최초 생성
 */
public class Coin {
    public void solve(Integer price, ArrayList<Integer> coinList) {
        int totalCoinCount = 0;
        int coinNum;
        ArrayList<Integer> detail = new ArrayList<>();

        for (Integer index : coinList) {
            coinNum = price / index;
            price -= (coinNum * index);
            totalCoinCount += coinNum;
            detail.add(coinNum);
            System.out.println(index + "원 :" + coinNum + "개");
        }
        System.out.println("총 동전 개수: " + totalCoinCount + "개");
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));

        Coin coin = new Coin();
        coin.solve(4720, coinList);
    }
}
