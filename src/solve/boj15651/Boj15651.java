package solve.boj15651;

import java.util.Scanner;

/**
 * packageName            : solve
 * fileName              : Boj15651
 * author                : sunkyu
 * date                  : 2022/03/05
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/03/05           sunkyu             최초 생성
 */
public class Boj15651 {
    // 1~N 까지 자연수 중에서 M개를 고른다
    // 같은 수를 여러번 구해도 된다

    // 1 ~ N 까지 첫번째 수를 고정한다.
    // 그 이후에 M 개를 맞추어 숫자를 출력한다.

    public void solve15651(Integer N, Integer M) {
        if (1 <= M && M <= N && N <= 7) {
            for (int i = 1; i <= N; i++) {
                Integer count = 1;
                System.out.print(i + " ");

                for (int j = 1; j <= N; j++) {
                    if (!count.equals(M)) {
                        System.out.print(j + " ");
                        count += 1;
                    } else {
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Boj15651 boj15651 = new Boj15651();
        boj15651.solve15651(n, m);
    }
}
