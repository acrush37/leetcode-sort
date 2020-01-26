package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 */
public class SortMatrixDiagonally {

    public static void main(String... args) {

        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        SortMatrixDiagonally sortMatrixDiagonally = new SortMatrixDiagonally();
        System.out.println(sortMatrixDiagonally.diagonalSort(mat));
    }

    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < n; i++) {

            int x = 0, y = i;
            List<Integer> t = new ArrayList<>();
            while (x < m && y < n) t.add(mat[x++][y++]);
            Collections.sort(t);
            x = 0;
            y = i;
            for (int z : t) mat[x++][y++] = z;
        }

        for (int i = 1; i < m; i++) {

            int x = i, y = 0;
            List<Integer> t = new ArrayList<>();
            while (x < m && y < n) t.add(mat[x++][y++]);
            Collections.sort(t);
            x = i;
            y = 0;
            for (int z : t) mat[x++][y++] = z;
        }

        return mat;
    }

}
