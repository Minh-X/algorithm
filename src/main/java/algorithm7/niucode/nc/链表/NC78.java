package algorithm7.niucode.nc.链表;

import algorithm7.niucode.util.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: permission
 * @Date: 2023/1/14 0:10
 * @Version: 1.0
 * @ClassName: NC78
 * @Description: 反转链表
 */
public class NC78 {

    public static void main(String[] args) {
        ListNode s = new ListNode(1);
        s.next = new ListNode(2);
        s.next.next = new ListNode(3);
        ListNode node = r2(s);
        while (node!=null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        return r2(head);
    }

    // 栈实现
    private static ListNode r2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res;
        head = stack.pop();
        res = head;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        return res;
    }

    private ListNode r1(ListNode head) {
        ListNode temp = head;
        ListNode cur = head;
        ListNode next = null;
        while (cur.next != null) {
            cur = cur.next;
            temp.next = next;
            next = temp;
            temp = cur;
        }
        cur.next = next;
        return cur;
    }

}
