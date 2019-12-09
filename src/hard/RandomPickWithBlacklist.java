package hard;

import java.util.*;

/*
    Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.

    Optimize it such that it minimizes the call to system’s Math.random().
 */
public class RandomPickWithBlacklist {

    private int n;

    private List<Integer> f = new ArrayList<>();

    public static void main(String... args) {

        int[] blacklist = {1, 3, 6};
        RandomPickWithBlacklist randomPickWithBlacklist = new RandomPickWithBlacklist(10, blacklist);
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
    }

    public RandomPickWithBlacklist(int N, int[] blacklist) {

        Random random = new Random();
        Set<Integer> t = new HashSet<>();
        for (int x : blacklist) t.add(x);

        if (blacklist.length > 0.99 * N) {
            for (int i = 0; i < N; i++) if (!t.contains(i)) f.add(i);
        } else for (int i = 0; i < 100000; i++) {
            int x = random.nextInt(N);
            if (!t.contains(x)) f.add(x);
        }

        Collections.shuffle(f);
    }

    public int pick() {
        return f.get(n = (n+1) % f.size());
    }

}
