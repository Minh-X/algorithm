package algorithm7.leetcode.链表;


import algorithm7.niucode.nc.链表.NC51;
import algorithm7.niucode.util.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/13 19:54
 * @Version: 1.0
 * @ClassName: LC23
 * @Description: 23. 合并K个升序链表
 */
public class LC23 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[2];
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(15);
        list[0] = l1;
        list[1] = l2;

        ListNode head = mergeKLists(list);
        ListNode printNode = head;
        while (printNode.next!=null) {
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> priorityQueue = new PriorityQueue(new MyComparator());
        // 先把k个链表的头节点添加到优先级队列
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        // 返回队首,k个链表中头节点中最小的node,用作结果head
        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        // 将head节点的下一个node加入到优先级队列(取一个后,再将取出的node的next加入到优先级队列)
        if (pre.next != null) {
            priorityQueue.add(pre.next);
        }
        // 循环取出优先级队列的node,每次取出一个最小的node后再将其下一个node加入到队列
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            pre.next = node;
            pre = node;
            if (node.next != null) {
                priorityQueue.add(pre.next);
            }
        }
        return head;
    }

    static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            ListNode ln1 = (ListNode) o1;
            ListNode ln2 = (ListNode) o2;
            return ln1.val - ln2.val;
        }
    }
}
