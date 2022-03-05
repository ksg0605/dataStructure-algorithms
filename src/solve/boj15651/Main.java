package solve.boj15651;

import java.util.Scanner;

/**
 * packageName            : solve.boj15651
 * fileName              : Main
 * author                : sunkyu
 * date                  : 2022/03/05
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/03/05           sunkyu             최초 생성
 */
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
    // 아직 M 개를 고르지 않음 => k 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void recFunc(int k) {
        // 다 골랐을 때
        if (k == M + 1) {
            // selected[1,,,M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) {
                stringBuilder.append(selected[i]).append(' ');
            }
            stringBuilder.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                // k 번째에 cand가 올 수 있으면
                selected[k] = cand;

                // k + 1 번부터 M 번까지 잘 채워주는 함수를 호출해준다.
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(stringBuilder.toString());
    }


}
