package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;

/**
 * @Author: permission
 * @Date: 2023/1/18 16:05
 * @Version: 1.0
 * @ClassName: NC102
 * @Description: NC102 在二叉树中找到两个节点的最近公共祖先
 */
public class NC102 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) {
            return -1;
        }
        return lowestCommonAncestor_Handle(root, o1, o2).resNode.val;
    }

    /*
            p1 在左
            p2 在右
            p3 root
     */
    private Info lowestCommonAncestor_Handle(TreeNode root, int a, int b) {
        if (root == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = lowestCommonAncestor_Handle(root.left, a, b);
        Info rightInfo = lowestCommonAncestor_Handle(root.right, a, b);
        boolean findA = false;
        boolean findB = false;
        TreeNode resNode = null;
        if (root.val == a || leftInfo.findA || rightInfo.findA) {
            findA = true;
        }
        if (root.val == b || leftInfo.findB || rightInfo.findB) {
            findB = true;
        }

        //p1 与root无关（左树已经找到答案）
        if (leftInfo.resNode != null) {
            resNode = leftInfo.resNode;
        }
        //p2 与root无关（右树已经找到答案）
        else if (rightInfo.resNode != null) {
            resNode = rightInfo.resNode;
        }
        //p3 与root有关（root的左右为a，b），答案就是root
        else if (findA && findB) {
            resNode = root;
        }

        return new Info(findA, findB, resNode);
    }

    public static class Info {
        public boolean findA;
        public boolean findB;
        public TreeNode resNode;

        public Info(boolean findA, boolean findB, TreeNode resNode) {
            this.findA = findA;
            this.findB = findB;
            this.resNode = resNode;
        }
    }
}
