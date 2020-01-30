package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    You are given an integer array nums and you have to return a new counts array.

    The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 */
public class CountOfSmallerNumbersAfterSelf {

    public static void main(String... args) {

        int[] nums = {5, 2, 6, 1};
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        System.out.println(countOfSmallerNumbersAfterSelf.countSmaller(nums));
    }

    private int find(List<Integer> t, int target) {

        int l = 0, r = t.size();

        while (l < r) {

            int mid = (l + r) >> 1;

            if (t.get(mid) < target) l = mid + 1;
            else r = mid;
        }

        t.add(l, target);
        return l;
    }

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        Integer[] f = new Integer[n];
        List<Integer> t = new ArrayList<>();
        for(int i = n-1; i >= 0; i--) f[i] = find(t, nums[i]);
        return Arrays.asList(f);
    }

}
