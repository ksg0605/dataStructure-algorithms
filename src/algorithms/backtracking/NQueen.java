package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Objects;

/**
 * packageName            : algorithms.backtracking
 * fileName              : NQueen
 * author                : sunkyu
 * date                  : 2022/03/05
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/03/05           sunkyu             최초 생성
 */
public class NQueen {

    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        for (int index = 0; index < currentRow; index++) {
            if ((Objects.equals(candidate.get(index), currentCol)) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index)) {
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (Objects.equals(currentRow, N)) {
            System.out.println(currentCandidate);
        }

        for (int index = 0; index < N; index++) {
            if (this.isAvailable(currentCandidate, index)) {
                currentCandidate.add(index);
                this.dfsFunc(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<Integer>());
    }

}
