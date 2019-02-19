package Amazon_OA2;

/**
 * Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
 *
 * Example
 * Given a binary tree:
 *
 *      1
 *    /   \
 *  -5     2
 *  / \   /  \
 * 0   3 -4  -5
 * return the node with value 3.
 *
 */
public class MaximumSubTree {
    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static TreeNode result = null;
    public static int maxWeight = Integer.MIN_VALUE;
    public static TreeNode findSubTree(TreeNode root) {
        helper(root);
        return result;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftWeight = helper(root.left);
        int rightWeight = helper(root.right);

        if (result == null || root.val + leftWeight + rightWeight > maxWeight) {
            result = root;
            maxWeight = root.val + leftWeight + rightWeight;
        }

        return root.val + leftWeight + rightWeight;
    }
}
