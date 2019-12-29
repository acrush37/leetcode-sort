package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given two binary search trees root1 and root2.

    Return a list containing all the integers from both trees sorted in ascending order.
 */
public class AllElementsInTwoBinarySearchTrees {

    private List<Integer> t = new ArrayList<>();

    public static void main(String... args) {

        AllElementsInTwoBinarySearchTrees allElementsInTwoBinarySearchTrees = new AllElementsInTwoBinarySearchTrees();
        System.out.println(allElementsInTwoBinarySearchTrees.getAllElements(null, null));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        t.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        dfs(root1);
        dfs(root2);
        Collections.sort(t);
        return t;
    }

}
