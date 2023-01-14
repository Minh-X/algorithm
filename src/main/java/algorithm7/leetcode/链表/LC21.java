package algorithm7.leetcode.链表;

import algorithm7.niucode.util.ListNode;

/**
 * @Author: permission
 * @Date: 2023/1/13 17:46
 * @Version: 1.0
 * @ClassName: LC21
 * @Description: 21. 合并两个有序链表
 */
public class LC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val > list2.val ? list2 : list1;//两个链表头节点val小的作为合并后的head
        //接下来判断头节点第二个节点和另一个链表的头节点谁小,作为最终结果的第二个节点
        ListNode cur1 = head.next;//指向头节点的下一个节点
        ListNode cur2 = head == list1 ? list2 : list1;//两个链表初始头节点val大的
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                pre.next = cur2;
                pre = pre.next;
                cur2 = cur2.next;
            } else {
                pre.next = cur1;
                pre = pre.next;
                cur1 = cur1.next;
            }
        }
        if (cur1 != null) {
            pre.next = cur1;
        }
        if (cur2 != null) {
            pre.next = cur2;
        }
        return head;
    }
}
