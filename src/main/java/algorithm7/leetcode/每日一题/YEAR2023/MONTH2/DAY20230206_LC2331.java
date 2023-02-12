package algorithm7.leetcode.每日一题.YEAR2023.MONTH2;

import algorithm7.leetcode.util.TreeNode;

/**
 * @Author: permission
 * @Date: 2023/2/6 0:12
 * @Version: 1.0
 * @ClassName: LC2331_20230206
 * @Description: 2331. 计算布尔二叉树的值
 */
public class DAY20230206_LC2331 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        boolean res = evaluateTree(root);
        System.out.println(res);

    }

    public static boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private static boolean dfs(TreeNode root) {
        if (root.left == null) {
            return root.val == 1 ? true : false;
        }
        if (root.val == 2) {//OR
            return dfs(root.left) || dfs(root.right);
        } else {//AND
            return dfs(root.left) && dfs(root.right);
        }
    }
}