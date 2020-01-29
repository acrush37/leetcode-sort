package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;

/*
    In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

    Rearrange the barcodes so that no two adjacent barcodes are equal.

    You may return any answer, and it is guaranteed an answer exists.
 */
public class DistantBarcodes {

    public static void main(String... args) {

        int[] barcodes = {1, 1, 1, 2, 2, 2};
        DistantBarcodes distantBarcodes = new DistantBarcodes();
        System.out.println(distantBarcodes.rearrangeBarcodes(barcodes));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {

        int k = 0;
        int[] result = new int[barcodes.length];
        Map<Integer, Integer> f = new HashMap<>();
        for (int x : barcodes) f.put(x, f.getOrDefault(x, 0) + 1);
        List<Entry<Integer, Integer>> t = new ArrayList<>(f.entrySet());
        t.sort((x, y) -> y.getValue() - x.getValue());

        for (Entry<Integer, Integer> e : t) {

            int x = e.getKey(), y = e.getValue();

            for (int i = 0; i < y; i++) {
                if (k >= result.length) k = 1;
                result[k] = x;
                k += 2;
            }
        }

        return result;
    }

}
