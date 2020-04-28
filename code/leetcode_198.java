import java.util.Stack;

/**
 * Created by xieli on 2020/4/28.
 */

/*
 * [198] 打家劫舍
 *
 * 题目:你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的
 *      唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
 *      被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你
 *      在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 思路:动态规划
 *
 *
 *
 *
 *
 */


public class leetcode_198 {

    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int x : nums) {
            int temp = x;
            curMax = Math.max(preMax + x, curMax);
            preMax = temp;
        }
        return curMax;
    }

}
