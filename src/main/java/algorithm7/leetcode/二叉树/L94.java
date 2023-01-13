package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: permission
 * @Date: 2023/1/13 13:44
 * @Version: 1.0
 * @ClassName: L94
 * @Description: 二叉树中序遍历
 */
public class L94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        inorder1(root, list);
        return list;
    }

    // 非递归  中序遍历：左链入栈
    //记忆：中序遍历不忘“左链入栈”
    private void inorder1(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }


    // 递归
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
