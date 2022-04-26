package list;

/*
82.删除排序链表中的重复元素Ⅱ
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead, look = pre.next;
        while (look != null && look.next != null) {
            if (look.val == look.next.val) {
                while (look.next != null && look.val == look.next.val) {
                    look = look.next;
                }
                pre.next = look.next;
            } else {
                pre = pre.next;
            }
            look = look.next;
        }
        return preHead.next;
    }
}
