package medium;

import java.util.Arrays;
import java.util.List;

/*
    Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.

    If there are more than one possible results, return the longest word with the smallest lexicographical order.
    If there is no possible result, return the empty string.
 */
public class LongestWordInDictionaryThroughDeleting {

    public static void main(String... args) {

        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        LongestWordInDictionaryThroughDeleting longestWordInDictionaryThroughDeleting = new LongestWordInDictionaryThroughDeleting();
        System.out.println(longestWordInDictionaryThroughDeleting.findLongestWord("abpcplea", d));
    }

    public String findLongestWord(String s, List<String> d) {

        d.sort((x, y) -> {

            int a = x.length();
            int b = y.length();
            if (a != b) return b-a;
            return x.compareTo(y);
        });

        char[] ch = s.toCharArray();
        int m = ch.length;

        for (String word : d) {

            int n = word.length();
            if (n > m) continue;
            char[] c = word.toCharArray();
            boolean flag = true;
            int i = m-1;

            while (--n >= 0) {

                while (i >= 0 && ch[i] != c[n]) i--;

                if (i-- == -1) {
                    flag = false;
                    break;
                }
            }

            if (flag) return word;
        }

        return "";
    }

}
