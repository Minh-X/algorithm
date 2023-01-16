package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;
import org.omg.PortableServer.RequestProcessingPolicy;
import sun.reflect.generics.tree.Tree;

import java.awt.*;
import java.util.ArrayList;
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

        String s = serialize(root);
        System.out.println(s);
        System.out.println();
        TreeNode head = deserialize(s);
        preOrderPrinTree(head);

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
        System.out.println(data);
        data = data.replaceAll("(\\[|\\])|\\s", "");
        System.out.println(data);
        String[] strs = data.split(",");
        for (int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }
        System.out.println();
        TreeNode root = preOrderDeserialize(queue);
        return root;
    }

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


    public String serialize2(TreeNode root) {
        if(root==null) return "";
        ArrayList res=new ArrayList();
        LinkedList<TreeNode> qu=new LinkedList<>();
        qu.addFirst(root);
        while(!qu.isEmpty()){
            TreeNode node=qu.removeLast();
            if(node==null){
                res.add("null");
                continue;
            }else{
                res.add(node.val);
                qu.addFirst(node.left);
                qu.addFirst(node.right);
            }
        }
        StringBuilder r=new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            r.append(res.get(i));
            if(i<res.size()-1) r.append(",");
        }
        return r.toString();
    }

}
