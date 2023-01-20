package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/17 14:07
 * @Version: 1.0
 * @ClassName: NC60
 * @Description: NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 */
public class NC60 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.right = new TreeNode(7);
        boolean[] booleans = judgeIt(head);
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }

    }

    public static boolean[] judgeIt(TreeNode root) {
        // write code here
        boolean[] b = new boolean[2];
        b[0] = isBST(root);
        b[1] = isCompleteTree(root);
        return b;
    }

    //判断是否是搜索二叉树（左子树小于根，右子树大于根， 中序遍历结果得到一个有序列表）
    private static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST_Judge(root).isBST;
    }
    //判断是否是完全二叉树（去掉最后一层为完美二叉树，最后一层左对齐）  除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐
    private static boolean isCompleteTree(TreeNode root) {
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
            if (flag && (l != null || r!=null)) {
                return false;
            }
            if (l!=null) {
                queue.add(l);
            }
            if (r!=null) {
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
        1.左树是否为搜索树
        2.右树是否为搜索树
        3.root节点value大于左树最大值
        4.root节点value小于右树最小值
        （使用Info类包装当前节点是否为搜索树，当前节点和子节点的最大值，最小值，isBST、max、min）
    */
    private static Info isBST_Judge(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = isBST_Judge(root.left);
        Info rightInfo = isBST_Judge(root.right);

        boolean isBST = true;
        int max = root.val;
        int min = root.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }

        if (leftInfo != null && leftInfo.max >= root.val) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.min <= root.val) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }


    //用于判断二叉搜索树的info
    public static class Info {
        public boolean isBST;
        public int max;//子树最大值
        public int min;//子树最小值

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
