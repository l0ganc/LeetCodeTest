package Cohesity;

/**
 * Time complexity : O(m).
 * A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
 *
 * Space complexity : O(m).
 * The depth of the recursion tree can go upto mm in the case of a skewed tree.
 * In average case, depth will be O(logm).
 */
public class MergeTwoBinaryTreeLC617 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
