/*
 * [617] 合并二叉树
 *
 * 题目:给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *      你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为
 *      节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 *
 *
 *
 * 思路:1.递归解法,时间复杂度为O(N)，其中 N 是两棵树中节点个数的较小值
 *      2.迭代 + 栈，时间复杂度为O(N)，其中 N 是两棵树中节点个数的较小值
 *
 *
 *
 */


import java.util.Stack;

class leetcode_617 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);

        return res;
    }

    public TreeNode mergeTrees_02(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1,t2});

        while (!stack.isEmpty()){

            TreeNode[] t = stack.pop();

            if (t[0] == null || t[1] == null){  //必须判定，不然后面的 t[0].val = t[0].val + t[1].val; 会报空指针
                continue;
            }

            t[0].val = t[0].val + t[1].val;

            if (t[0].left == null){
                t[0].left = t[1].left;
            }else {
                stack.push(new TreeNode[]{t[0].left,t[1].left});
            }

            if (t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.push(new TreeNode[]{t[0].right,t[1].right});
            }

        }

        return t1;
    }

    public static void main(String[] args) {
        leetcode_617 leetcode_621 = new leetcode_617();
    }

}

