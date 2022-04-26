package list;

/*
83.删除排序链表中的重复元素
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val != pre.next.next.val) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return preHead.next;
    }
}
