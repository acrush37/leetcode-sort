package medium;

/*
    Given an array with n objects colored red, white or blue, sort them in-place so that objects
    of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {

    public static void main(String... args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {

        int left = 0, right = nums.length - 1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {

                int t = nums[i];
                nums[i] = nums[left];
                nums[left++] = t;
            } else if (nums[i] == 2) {

                int t = nums[i];
                nums[i--] = nums[right];
                nums[right--] = t;
            }
        }
    }

}
