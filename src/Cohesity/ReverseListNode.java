package Cohesity;

public class ReverseListNode {
    public ListNode reverList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
