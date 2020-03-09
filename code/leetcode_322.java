/*
 * [322] 零钱兑换
 *
 * 题目:给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以
 *      凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 思路:1.贪心+深度优先搜索DFS
 *      2.动态规划，自下向上
 *
 *
 *
 */


import java.util.Arrays;

class leetcode_322 {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length - 1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChange(int index, int[] coins, int count, int needAmount) {
        if (needAmount == 0) {
            ans = Math.min(count, ans);
            return;
        }

        if (index < 0) {
            return;
        }

        int i = needAmount / coins[index];
        for (int k = i; k >= 0 && count + k < ans; k--) {
            coinChange(index - 1, coins, count + k, needAmount - k * coins[index]);
        }
    }


    public int coinChange_02(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memo[i - coins[j]] < min) {
                    min = memo[i - coins[j]] + 1;
                }
            }
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        leetcode_322 leetcode_167 = new leetcode_322();
    }

}

