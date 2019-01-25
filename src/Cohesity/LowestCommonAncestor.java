package Cohesity;

public class LowestCommonAncestor {
    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    // follow up: what if a or b might not be int the tree?
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(7);

        /**
        TreeNode solu = LCA(root, a, b);
        // what if either a or b might not be int the tree
        if (solu == null) {
            return null;
        } else if (solu != a && solu != b) {
            return solu;
        } else {
            if (solu == a) {
                return LCA(solu, b, b) == null ? null : solu;
            } else {
                return LCA(solu, a, a) == null ? null : solu;
            }
        }
         */
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
