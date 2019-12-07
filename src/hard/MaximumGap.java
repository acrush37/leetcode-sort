package hard;

/*
    Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

    Return 0 if the array contains less than 2 elements.
 */
public class MaximumGap {

    public static void main(String... args) {

        int[] nums = {3, 6, 9, 1};
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {

        int n = nums.length;
        int[] t = new int[n];
        int max = 0, exp = 1, radix = 10, result = 0;
        for (int x : nums) max = Math.max(max, x);

        while (max >= exp) {

            int[] f = new int[radix];
            for (int i = 0; i < n; i++) f[nums[i] / exp % 10]++;
            for (int i = 1; i < radix; i++) f[i] += f[i-1];
            for (int i = n-1; i >= 0; i--) t[--f[nums[i] / exp % 10]] = nums[i];
            for (int i = 0; i < n; i++) nums[i] = t[i];
            exp *= 10;
        }

        for (int i = 1; i < n; i++) result = Math.max(result, nums[i] - nums[i-1]);
        return result;
    }

}
