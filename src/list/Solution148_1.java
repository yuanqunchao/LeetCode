package list;

/*
148.排序链表——归并排序
 */
public class Solution148_1 {
    public ListNode sortList(ListNode head) {
        // 调用归并排序
        return mergeSort(head, null);
    }

    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        return mergeTwoList(mergeSort(head, mid), mergeSort(mid, tail));
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        }
    }

}
