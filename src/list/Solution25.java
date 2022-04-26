package list;

/*
25.K个一组翻转链表
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return preHead.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverseList(pre.next, tail);
            pre.next = reverse[0];
            reverse[1].next = next;
            pre = reverse[1];
        }
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
