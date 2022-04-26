package list;

/*
328.奇偶链表
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode preOdd = new ListNode();
        ListNode preO = preOdd;
        ListNode preEven = new ListNode();
        ListNode preE = preEven;
        while (head != null) {
            preO.next = head;
            preO = preO.next;
            head = head.next;
            if (head != null) {
                preE.next = head;
                preE = preE.next;
                head = head.next;
            }
        }
        preE.next = null;
        preO.next = preEven.next;
        return preOdd.next;
    }
}
