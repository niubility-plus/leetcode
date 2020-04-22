/*
 * [513] 找树左下角的值
 *
 * 题目:给定一个二叉树，在树的最后一行找到最左边的值。
 *
 *
 * 思路:1.迭代，层序遍历
 *      2.递归
 *
 *
 *
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xieli on 2020/4/20.
 */
public class leetcode_513 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            res = queue.peek().val;
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

    int res = 0;
    int maxDepth = 0;

    public int findBottomLeftValue_02(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null)
            return;
        if (++depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }

        if (root.left != null)
            helper(root.left, depth);
        if (root.right != null)
            helper(root.right, depth);
    }

}
