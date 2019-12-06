package medium;

import java.util.*;

/*
    Given a list of non negative integers, arrange them such that they form the largest number.
 */
public class LargestNumber {

    public static void main(String... args) {

        int[] nums1 = {128, 12};
        int[] nums2 = {34, 3, 30};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(nums1));
        System.out.println(largestNumber.largestNumber(nums2));
    }

    public String largestNumber(int[] nums) {

        List<String> t = new ArrayList<>();
        for (int x : nums) t.add(x + "");
        Collections.sort(t, (x, y) -> (y + x).compareTo(x + y));
        if ("0".equals(t.get(0))) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : t) sb.append(s);
        return sb.toString();
    }

}
