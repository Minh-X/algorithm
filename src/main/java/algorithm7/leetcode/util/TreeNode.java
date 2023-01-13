package algorithm7.leetcode.util;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:10
 * @Version: 1.0
 * @ClassName: TreeNode
 * @Description: Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
