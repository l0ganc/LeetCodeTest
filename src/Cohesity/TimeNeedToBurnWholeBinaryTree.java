package Cohesity;

public class TimeNeedToBurnWholeBinaryTree {
    static class MyTreeNode {
        int val;
        MyTreeNode parent;
        MyTreeNode left;
        MyTreeNode right;
        public MyTreeNode(int val) {
            this.val = val;
        }
    }

    static int lenToRoot = 0;
    private static MyTreeNode findRoot(MyTreeNode startNode) {
        if (startNode == null || startNode.parent == null) {
            return startNode;
        }

        MyTreeNode p = startNode;
        while (p.parent != null) {
            p = p.parent;
            lenToRoot++;
        }
        return p;
    }

    private static int findMaxLength(MyTreeNode root) {
        int lLength = 0;
        int rLength = 0;

        MyTreeNode p = root, q = root;
        while (p.left != null) {
            p = p.left;
            lLength++;
        }

        while (q.right != null) {
            q = q.right;
            rLength++;
        }

        return Math.max(lLength, rLength);
    }

    private static int timeNeedToBurnWholeBST(MyTreeNode startNode) {
        if (startNode == null) {
            return 0;
        }
        MyTreeNode root = findRoot(startNode);
        int maxLengthFromRoot = findMaxLength(root);
        int upLength = maxLengthFromRoot + lenToRoot;
        int downLength = findMaxLength(startNode);

        return Math.max(upLength, downLength);

    }

}


