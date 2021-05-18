package Didi;

public class LC98 {
    /**
     Time complexity : O(n) since we visit each node exactly once.
     Space complexity : O(n) since we keep up to the entire tree.

     可以用分治做
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (min != null && root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left & right;
    }
}
