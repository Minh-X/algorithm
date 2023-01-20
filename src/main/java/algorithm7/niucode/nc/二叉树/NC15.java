package algorithm7.niucode.nc.二叉树;

import algorithm7.niucode.base.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author: permission
 * @Date: 2023/1/17 2:20
 * @Version: 1.0
 * @ClassName: NC15
 * @Description: NC15 求二叉树的层序遍历
 */
public class NC15 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(3);
        TreeNode rll = new TreeNode(2);
        root.left = rl;
        root.right = rr;
        rl.left = rll;

        ArrayList<ArrayList<Integer>> list = levelOrder(root);
        list.stream().forEach(l -> {
            l.stream().forEach(System.out::println);
        });
    }

    /*
        先求有多少层，每层对应一个list 最后全放入大的List
     */

    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer> > res = new ArrayList();
        if(root == null)
            //如果是空，则直接返回空数组
            return res;
        //队列存储，进行层次遍历
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList();
            int n = q.size();
            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                row.add(cur.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            //每一层加入输出
            res.add(row);
        }
        return res;
    }
}
