package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/16 21:49
 * @Version: 1.0
 * @ClassName: NC198
 * @Description: NC198 判断是不是完全二叉树
 */
public class NC198 {

    public boolean isCompleteTree(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        return isCompleteTree_Judge(root);
    }

    /*
        使用bfs按层遍历
        1.某个节点有右节点，无左节点， 返回false
        2.如果遇到第一个两个子节点不双全的节点，之后遍历到的节点必须是叶子节点（无左右子节点）
     */
    private static boolean isCompleteTree_Judge(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;//是否遇到过左右孩子不双全的节点
        TreeNode l;
        TreeNode r;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            // 左为null，右不为null，返回false
            if (l == null && r != null) {
                return false;
            }
            // 如果遇到过左右孩子不双全的节点（flag为true）， 并且当前节点不是叶子节点（左右有一个不为null）
            if (flag && (l != null || r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            // 如果遇到过左右孩子不双全的节点，将flag设为true（左右都为null 或者 左不为null右为null（左null右不为null在上面已经返回false））
            if ((l == null && r == null) || (l != null && r == null)) {
                flag = true;
            }

        }
        return true;
    }

    /*
            递归
            p1 左右孩子都是满的或都没有，高度一样
            p2 左树不满（符合完全二叉树），右满，左树高度比右树大1
            p3 左树满，右树满，左树高度大1
            p4 左树满，右数不满（符合完全二叉树），左右高度一样
     */
    private static boolean isCompleteTree_Judge2(TreeNode root) {
        Info rootInfo = isCompleteTree_Handle(root);
        return rootInfo.isComplete;
    }

    private static Info isCompleteTree_Handle(TreeNode root) {
        if (root == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = isCompleteTree_Handle(root.left);
        Info rightInfo = isCompleteTree_Handle(root.right);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;//是否满
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;//高度
        boolean isComplete = false;//是否完全
        // p1 满肯定是完全
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isComplete = true;
        }
        // p2
        else if (leftInfo.isComplete && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isComplete = true;
        }
        // p3
        else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isComplete = true;
        }
        // p4
        else if (leftInfo.isFull && rightInfo.isComplete && leftInfo.height == rightInfo.height) {
            isComplete = true;
        }
        return new Info(isFull, isComplete, height);
    }

    public static class Info {
        public boolean isFull;//是否满
        public boolean isComplete;//是否完全
        public int height;//高度

        public Info(boolean isFull, boolean isComplete, int height) {
            this.isFull = isFull;
            this.isComplete = isComplete;
            this.height = height;
        }
    }

}
