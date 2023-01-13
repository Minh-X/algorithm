package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:34
 * @Version: 1.0
 * @ClassName: L104
 * @Description: 二叉树的最大深度
 */
public class L104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
