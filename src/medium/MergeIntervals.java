package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {

    public static void main(String... args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) return intervals;
        List<int[]> t = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);

        for (int i = 1; i < n; i++)
            if (intervals[i][0] > intervals[i-1][1]) t.add(intervals[i-1]);
            else {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i-1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            }

        t.add(intervals[n-1]);
        int[][] f = new int[t.size()][2];
        t.toArray(f);
        return f;
    }

}
