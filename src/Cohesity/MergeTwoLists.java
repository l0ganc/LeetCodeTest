package Cohesity;

import java.util.LinkedHashMap;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = new ListNode(p.val);
                p = p.next;
            } else {
                cur.next = new ListNode(q.val);
                q = q.next;
            }
            cur = cur.next;
        }
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }

        return dummy.next;
    }

}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
