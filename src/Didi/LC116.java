package Didi;

public class LC116 {
    // 116. Populating Next Right Pointers in Each Node


    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    // 树的问题 90% ==> recursion
    // Preorder

    // cur.left.next = cur.right
    // cur.right.next = cur.next.left
    // Time = O(n)
    // Space = O(log(n))

    // method 1: 层次遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Node start = root;

        while (start != null) {
            Node cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }

    // method 2: recursive
    public Node connect2(Node root) {
        if (root == null || root.left == null) return root;

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connect2(root.left);
        connect2(root.right);

        return root;
    }
}
