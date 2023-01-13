package algorithm7.leetcode.二叉树;

import algorithm7.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: permission
 * @Date: 2023/1/13 14:08
 * @Version: 1.0
 * @ClassName: L145
 * @Description: 二叉树后序遍历
 */
public class L145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;

    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }


}
