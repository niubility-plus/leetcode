/*
 * [215] 数组中第k个最大元素
 *
 * 题目:在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 * 思路:1.排序,时间复杂度 O(NlogN)，空间复杂度 O(1)
 *      2.堆
 *
 *
 *
 */


import java.util.Arrays;
import java.util.PriorityQueue;

class leetcode_215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest_02(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        leetcode_215 leetcode_524 = new leetcode_215();
        int[] test=new int[]{3,2,1,5,6,4};
    }

}

