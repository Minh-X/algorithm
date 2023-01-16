package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/16 14:52
 * @Version: 1.0
 * @ClassName: LC297
 * @Description: 297. 二叉树的序列化与反序列化
 */
public class LC297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;

        String queue = bfsSerialize(root);
        System.out.println(queue);
        TreeNode head = bfsDeserialize(queue);
        preOrderPrinTree(head);

//        String s = serialize(root);
//        System.out.println(s);
//        System.out.println();
//        TreeNode head = deserialize(s);
//        preOrderPrinTree(head);

    }

    private static void preOrderPrinTree(TreeNode head) {
        if (head == null) {
            System.out.print("null" + " ");
            return;
        }
        System.out.print(head.val + " ");
        preOrderPrinTree(head.left);
        preOrderPrinTree(head.right);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<String> queue = new LinkedList<>();
        preOrderSerialize(root, queue);
        return queue.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        data = data.replaceAll("(\\[|\\])|\\s", "");
        String[] strs = data.split(",");
        for (int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }
        TreeNode root = preOrderDeserialize(queue);
        return root;
    }

    // dfs 先序先序遍历序列化
    private static void preOrderSerialize(TreeNode root, Queue<String> queue) {
        if (root == null) {
            queue.add(null);
            return;
        } else {
            queue.add(String.valueOf(root.val));
            preOrderSerialize(root.left, queue);
            preOrderSerialize(root.right, queue);
        }
    }

    //dfs 先序重建树
    private static TreeNode preOrderDeserialize(Queue<String> queue) {
        String value = queue.poll();
        if ("null".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = preOrderDeserialize(queue);
        root.right = preOrderDeserialize(queue);
        return root;
    }


    // bfs 先序先序遍历序列化
    private static String bfsSerialize(TreeNode root) {
        Queue<String> resStr = new LinkedList<>();//存序列化后的字符串，queue.toString()输出格式 [1, 2, 3, null, 7]
        if (root == null) {
            resStr.add(null);
            return resStr.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();//存节点（bfs顺序）
        queue.add(root);//先将头节点放入queue
        while (!queue.isEmpty()) { //按顺序取出
            TreeNode head = queue.poll();
            if (head != null) {
                resStr.add(String.valueOf(head.val));
                if (head.left != null) {
                    queue.add(head.left);
                } else {
                    queue.add(null);
                }
                if (head.right != null) {
                    queue.add(head.right);
                } else {
                    queue.add(null);
                }
            } else {
                resStr.add(null);
            }
        }
        return resStr.toString();
    }

    // bfs   反序列化
    private static TreeNode bfsDeserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Queue<String> valueQueue = new LinkedList<>();
        s = s.replaceAll("(\\[|\\])|\\s", "");
        String[] strs = s.split(",");
        for (int i = 0; i < strs.length; i++) {
            valueQueue.add(strs[i]);
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        String value = valueQueue.poll();
        TreeNode root = buildNode(value);
        if (root != null) {
            nodeQueue.add(root);
        }
        TreeNode head = null;
        while (!nodeQueue.isEmpty()) {
            head = nodeQueue.poll();
            head.left = buildNode(valueQueue.poll());
            head.right = buildNode(valueQueue.poll());
            if (head.left != null) {
                nodeQueue.add(head.left);
            }
            if (head.right != null) {
                nodeQueue.add(head.right);
            }
        }
        return root;
    }

    static TreeNode buildNode(String s) {
        if (s != null && !"null".equals(s)) {
            return new TreeNode(Integer.parseInt(s));
        }
        return null;
    }

}
