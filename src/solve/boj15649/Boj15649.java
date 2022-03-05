package solve.boj15649;

import java.util.Scanner;

/**
 * packageName            : solve.boj15649
 * fileName              : Boj15649
 * author                : sunkyu
 * date                  : 2022/03/05
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/03/05           sunkyu             최초 생성
 */
public class Boj15649 {

    // 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오
    // - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

    // 필요한 변수
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new int[M + 1];
    }

    static void recFunc(int k) {
        // 필요한 수를 다 찾았을 때
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        // 아닐때
        else {
            for (int j = 1; j <= N; j++) {
                boolean isUsed = false;
                for (int i = 1; i < k; i++) {
                    if (selected[i] == j) {
                        isUsed = true;
                    }
                }
                if (!isUsed) {
                    selected[k] = j;
                    recFunc(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
