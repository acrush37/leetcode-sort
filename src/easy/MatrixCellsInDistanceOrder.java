package easy;

import java.util.HashSet;
import java.util.Set;

/*
    We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

    Additionally, we are given a cell in that matrix with coordinates (r0, c0).

    Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.

    Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.
    (You may return the answer in any order that satisfies this condition.)
 */
public class MatrixCellsInDistanceOrder {

    public static void main(String... args) {

        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
        System.out.println(matrixCellsInDistanceOrder.allCellsDistOrder(2, 3, 1, 2));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int n = 0;
        int max = R + C + 1;
        Set<int[]>[] t = new Set[max];
        int[][] result = new int[R*C][2];

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {

                int distance = Math.abs(i - r0) + Math.abs(j - c0);
                if (t[distance] == null) t[distance] = new HashSet<>();
                t[distance].add(new int[]{i, j});
            }

        for (int i = 0; i < max; i++)
            if (t[i] != null)
                for (int[] x : t[i])
                    result[n++] = x;

        return result;
    }

}
