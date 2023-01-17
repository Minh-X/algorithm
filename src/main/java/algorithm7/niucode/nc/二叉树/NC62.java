package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;

/**
 * @Author: permission
 * @Date: 2023/1/17 13:33
 * @Version: 1.0
 * @ClassName: NC62
 * @Description: NC62 判断是不是平衡二叉树
 */
public class NC62 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        Info info = isBalance(head);
        System.out.println(info.isBalanced);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalance(root).isBalanced;
    }

    private static Info isBalance(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = isBalance(node.left);
        Info rightInfo = isBalance(node.right);
        boolean isBalanced = true;
        if (!leftInfo.isBalanced) {//左子树不平衡
            isBalanced = false;
        }
        if (!rightInfo.isBalanced) {//右子树不平衡
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {//高度差大于1
            isBalanced = false;
        }
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;//计算根节点高度
        return new Info(isBalanced, height);
    }

    public static class Info {
        boolean isBalanced;
        int height;
        public Info (boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
