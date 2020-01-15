package medium;

/*
    Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
    absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {

    public static void main(String... args) {

        int[] nums = {1, 2, 3, 1};
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int n = nums.length;

        for (int i = 0; i < n-1; i++) {

            int p = Math.min(n-1, i+k);

            for (int j = i+1; j <= p; j++)
                if (Math.abs((long) nums[i] - nums[j]) <= t)
                    return true;

        }

        return false;
    }

}
