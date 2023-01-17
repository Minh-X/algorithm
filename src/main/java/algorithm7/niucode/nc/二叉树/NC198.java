package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;
import sun.reflect.generics.tree.Tree;

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

    public boolean isCompleteTree (TreeNode root) {
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

}
