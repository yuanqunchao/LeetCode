package list;

/*
面试题02.05.链表求和
 */
public class Solution0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int r = 0;
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while (l1 != null || l2 != null || r > 0) {
            int add1 = l1 == null ? 0 : l1.val;
            int add2 = l2 == null ? 0 : l2.val;
            int sum = add1 + add2 + r;
            ListNode newNode = new ListNode(sum % 10);
            pre.next = newNode;
            pre = pre.next;
            r = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return preHead.next;
    }
}
