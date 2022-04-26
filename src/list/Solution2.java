package list;

/*
2.两数相加
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        int r = 0;
        while (l1 != null || l2 != null || r > 0) {
            int add1 = l1 == null ? 0 : l1.val;
            int add2 = l2 == null ? 0 : l2.val;
            int sum = add1 + add2 + r;
            ListNode newNode = new ListNode(sum % 10);
            r = sum / 10;
            pre.next = newNode;
            pre = pre.next;
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
