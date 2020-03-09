/*
 * [015] 三数之和
 *
 * 题目:给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *     请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 思路:1.数组遍历
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class leetcode_015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_015 leetcode_167 = new leetcode_015();
    }

}

