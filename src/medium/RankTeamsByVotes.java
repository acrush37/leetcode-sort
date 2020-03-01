package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    In a special ranking system, each voter gives a rank from highest to lowest to all teams participated
    in the competition. The ordering of teams is decided by who received the most position-one votes.

    If two or more teams tie in the first position, we consider the second position to resolve
    the conflict, if they tie again, we continue this process until the ties are resolved.

    If two or more teams are still tied after considering all positions, we rank them alphabetically based on
    their team letter. Given an array of strings votes which is the votes of all voters in the ranking systems.

    Sort all teams according to the ranking system described above.
    Return a string of all teams sorted by the ranking system.
 */
public class RankTeamsByVotes {

    public static void main(String... args) {

        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        System.out.println(rankTeamsByVotes.rankTeams(votes));
    }

    public String rankTeams(String[] votes) {

        int n = votes[0].length();
        int[][] f = new int[26][91];
        List<Character> t = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) t.add(votes[0].charAt(i));

        for (String s : votes)
            for (int i = 0; i < n; i++)
                f[i][s.charAt(i)]++;

        Collections.sort(t, (x, y) -> {

            for (int i = 0; i < n; i++)
                if (f[i][x] != f[i][y])
                    return f[i][y] - f[i][x];

            return x - y;
        });

        for (char c : t) sb.append(c);
        return sb.toString();
    }

}
