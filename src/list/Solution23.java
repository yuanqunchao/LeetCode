package list;

/*
23.合并K个排序链表
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return lists[left];
        } else {
            int mid = left + ((right - left) >> 1);
            return merge(mergeSort(lists, left, mid), mergeSort(lists, mid + 1, right));
        }
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        pre.next = head1 == null ? head2 : head1;
        return preHead.next;
    }

}
