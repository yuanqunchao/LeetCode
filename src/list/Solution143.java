package list;

/*
143.重排链表
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        ListNode head1 = head;
        while (head1 != null && head2 != null) {
            ListNode p1 = head1.next;
            ListNode p2 = head2.next;
            head1.next = head2;
            head2.next = p1;
            head1 = p1;
            head2 = p2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
