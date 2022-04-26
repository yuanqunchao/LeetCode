package list;

/*
24.两两交换链表中的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode next = pre.next;
            pre.next = pre.next.next;
            next.next = pre.next.next;
            pre.next.next = next;
            pre = next;
        }
        return preHead.next;
    }
}
