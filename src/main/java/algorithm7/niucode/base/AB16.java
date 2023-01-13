package algorithm7.niucode.base;

import algorithm7.niucode.base.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:51
 * @Version: 1.0
 * @ClassName: AB16
 * @Description: AB16 实现二叉树先序，中序和后序遍历
 */
public class AB16 {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        preorder(root, preList);
        inorder(root, inList);
        postorder(root, postList);

        int[][] res = new int[3][preList.size()];
        for (int i = 0; i < preList.size(); i++) {
            res[0][i] = preList.get(i);
            res[1][i] = inList.get(i);
            res[2][i] = postList.get(i);
        }
        return res;
    }

    private void postorder(TreeNode root, List<Integer> postList) {
        if (root == null) {
            return;
        }
        postorder(root.left, postList);
        postorder(root.right, postList);
        postList.add(root.val);
    }

    private void inorder(TreeNode root, List<Integer> inList) {
        if (root == null) {
            return;
        }
        inorder(root.left, inList);
        inList.add(root.val);
        inorder(root.right, inList);
    }

    private void preorder(TreeNode root, List<Integer> preList) {
        if (root == null) {
            return;
        }
        preList.add(root.val);
        preorder(root.left, preList);
        preorder(root.right, preList);
    }
}
