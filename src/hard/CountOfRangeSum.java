package hard;

/*
    Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.

    Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 */
public class CountOfRangeSum {

    public static void main(String... args) {

        int[] nums = {-2, 5, -1};
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        System.out.println(countOfRangeSum.countRangeSum(nums, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        int result = 0, n = nums.length;
        long[] f = new long[n+1];
        for (int i = 0; i < n; i++) f[i+1] = f[i] + nums[i];

        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++) {
                long k = f[j] - f[i];
                if (lower <= k && k <= upper) result++;
            }

        return result;
    }

}
