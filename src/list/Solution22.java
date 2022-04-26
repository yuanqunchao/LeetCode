package list;

/*
剑指Offer22.链表中倒数第k个节点
 */
public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead, ptr = preHead;
        for (int i = 0; i < k; i++) {
            ptr = ptr.next;
        }
        while (ptr != null) {
            pre = pre.next;
            ptr = ptr.next;
        }
        return pre;
    }
}
