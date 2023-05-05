package algorithm7.niucode.nc.链表;

import algorithm7.niucode.util.ListNode;

/**
 * @Author: permission
 * @Date: 2023/1/13 17:00
 * @Version: 1.0
 * @ClassName: NC33
 * @Description: NC33 合并两个排序的链表
 */
public class NC33 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(15);

        ListNode l22 = l2;
        ListNode l11 = l1;
        while (l11 != null) {
            System.out.print(l11.val + " ");
            l11 = l11.next;
        }
        System.out.println();

        while (l22 != null) {
            System.out.print(l22.val + " ");
            l22 = l22.next;
        }
        System.out.println();

        ListNode head = Merge(l1, l2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
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
