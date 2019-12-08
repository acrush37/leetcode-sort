package medium;

import java.util.Arrays;

/*
    Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 */
public class WiggleSortII {

    public static void main(String... args) {

        int[] nums = {6, 5, 5, 4};
        WiggleSortII wiggleSortII = new WiggleSortII();
        wiggleSortII.wiggleSort(nums);
        System.out.println(nums);
    }

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        int[] t = Arrays.copyOf(nums, n);
        Arrays.sort(t);
        int p = n;
        int mid = n >> 1;
        for (int i = 0; i < n; i++) nums[i] = (i & 1) == 1 ? t[--p] : t[--mid];
    }

}
