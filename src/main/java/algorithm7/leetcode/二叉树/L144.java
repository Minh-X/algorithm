package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:06
 * @Version: 1.0
 * @ClassName: L144
 * @Description: 二叉树的前序遍历
 */
public class L144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;

    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

}
