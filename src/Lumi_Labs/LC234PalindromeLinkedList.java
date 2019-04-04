package Lumi_Labs;

public class LC234PalindromeLinkedList {
    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     *
     * 先用快慢指针找中点然后reverse后半部分，最后两个指针比较是否相同
     */

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);   // reverse right half
        fast = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
