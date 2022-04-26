package list;

/*
19.删除链表的倒数第N个节点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead, ptr = preHead;
        for (int i = 0; i < n; i++) {
            ptr = ptr.next;
        }
        while (ptr.next != null) {
            pre = pre.next;
            ptr = ptr.next;
        }
        pre.next = pre.next.next;
        return preHead.next;
    }
}
