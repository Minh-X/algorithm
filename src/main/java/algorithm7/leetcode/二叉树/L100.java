package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:14
 * @Version: 1.0
 * @ClassName: L100
 * @Description: 相同的树
 */
public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
