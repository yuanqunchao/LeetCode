package list;

/*
92.反转链表Ⅱ
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode tail = pre;
        for (int i = 0; i < right - left + 1; i++) {
            tail = tail.next;
        }
        ListNode next = tail.next;
        ListNode[] reverse = reverseList(pre.next, tail);
        pre.next = reverse[0];
        reverse[1].next = next;
        return preHead.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}
