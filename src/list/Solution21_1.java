package list;

/*
21.合并两个有序链表
 */
public class Solution21_1 {
    /*
    方法一：迭代
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}
