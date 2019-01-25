package Cohesity;

/**
 * Given a binary tree where all the right nodes are either
 * leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree
 * where the original right nodes turned into left leaf nodes. Return the new root.
 *
 *
 * EXAMPLE:
 * Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 */



public class LC156BinaryTreeUpsideDown {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
