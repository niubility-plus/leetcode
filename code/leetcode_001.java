/*
 * [001] 两数之和
 *
 * 题目:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *
 *
 * 思路:1.哈希映射
 *
 *
 *
 */


import java.util.HashMap;
import java.util.Map;

class leetcode_001 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> res=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(res.containsKey(target-nums[i])){
                return new int[] {res.get(target-nums[i]),i};
            }
            res.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        leetcode_001 leetcode_167 = new leetcode_001();
    }

}

