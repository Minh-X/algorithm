package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;

import java.util.HashMap;

/**
 * @Author: permission
 * @Date: 2023/1/13 23:23
 * @Version: 1.0
 * @ClassName: LC105
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 */

/*
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

node   3,9,20,15,7      9,3,15,20,7
index  0,1,2 ,3 ,4      0,1,2 ,3 ,4

 */
public class LC105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder ==null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return f2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    //使用map记录中序数组
    private TreeNode f2(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, HashMap<Integer, Integer> valueIndexMap) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        // 找到中序中根节点的下标
//        int find = l2;
//        while (preorder[l1] != inorder[find]) {
//            find++;
//        }
        //使用 valueIndexMap 优化,避免每次递归循环中序数组
        int find = valueIndexMap.get(preorder[l1]);

        head.left = f2(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1, valueIndexMap);
        head.right = f2(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2, valueIndexMap);

        return head;
    }

    private TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        // 找到中序中根节点的下标
        int find = l2;
        while (preorder[0] != inorder[find]) {
            find++;
        }
        head.left = f(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1);
        head.right = f(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2);

        return head;
    }
}
