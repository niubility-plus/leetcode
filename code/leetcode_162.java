/**
 * Created by xieli on 2020/4/30.
 */


/*
 * [162] 寻找峰值
 *
 * 题目:峰值元素是指其值大于左右相邻值的元素。
 *      给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *      数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。你可以假设 
 *      nums[-1] = nums[n] = -∞。
 *
 *
 *
 * 思路:二分查找
 *      1.首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着
 *          只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
 *      2.根据上述结论，我们就可以使用二分查找找到峰值
 *      3.查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
 *      4.根据左右指针计算中间位置 m，并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，
 *          r = m，如果 m + 1 较大，则右侧存在峰值，l = m + 1
 *
 *
 *
 */


public class leetcode_162 {

    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
