package medium;

import java.util.*;

import static java.util.Map.Entry;

/*
    The power of an integer x is defined as the number of steps needed to transform x into 1
    using the following steps: if x is even then x = x / 2 if x is odd then x = 3 * x + 1

    Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power
    value in ascending order, if two or more integers have the same power value sort them by ascending order.

    Return the k-th integer in the range [lo, hi] sorted by the power value.
 */
public class SortIntegersByPower {

    private Map<Integer, Integer> f = new HashMap<>();

    public static void main(String... args) {

        SortIntegersByPower sortIntegersByPower = new SortIntegersByPower();
        System.out.println(sortIntegersByPower.getKth(12, 15, 2));
    }

    private int dfs(int x) {

        Integer y = f.get(x);
        if (y != null) return y;
        y = 1 + dfs((x & 1) == 0 ? x >> 1 : 3 * x + 1);
        f.put(x, y);
        return y;
    }

    public int getKth(int lo, int hi, int k) {

        f.put(1, 1);
        for (int i = lo; i <= hi; i++) if (!f.containsKey(i)) dfs(i);
        Map<Integer, List<Integer>> a = new TreeMap<>();

        for (int i = lo; i <= hi; i++) {

            int x = f.get(i);
            a.putIfAbsent(x, new ArrayList<>());
            a.get(x).add(i);
        }

        Iterator<Entry<Integer, List<Integer>>> it = a.entrySet().iterator();

        while (it.hasNext()) {

            Entry<Integer, List<Integer>> e = it.next();
            List<Integer> b = e.getValue();
            if (k <= b.size()) return b.get(k-1);
            k -= b.size();
        }

        return 1;
    }

}
