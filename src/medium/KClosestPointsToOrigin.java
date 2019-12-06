package medium;

import java.util.*;

/*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.
    The answer is guaranteed to be unique (except for the order that it is in.)
 */
public class KClosestPointsToOrigin {

    public static void main(String... args) {

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        System.out.println(kClosestPointsToOrigin.kClosest(points, 2));
    }

    public int[][] kClosest(int[][] points, int K) {

        int[][] result = new int[K][2];
        Map<Integer, Set<int[]>> m = new TreeMap<>();

        for (int[] x : points) {

            int y = x[0] * x[0] + x[1] * x[1];
            Set<int[]> z = m.get(y);
            if (z == null) z = new HashSet<>();
            z.add(new int[]{x[0], x[1]});
            m.put(y, z);
        }

        Collection<Set<int[]>> values = m.values();

        for (Set<int[]> s : values)
            for (int[] point : s) {
                if (K-- == 0) return result;
                result[K] = point;
            }

        return result;
    }

}
