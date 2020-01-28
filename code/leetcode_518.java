/*
 * [518] 最短无序连续子数组
 *
 * 题目:给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，
 *      那么整个数组都会变为升序排序。你找到的子数组应是最短的，请输出它的长度。
 *
 *
 *
 *
 * 思路:1.如果最右端的一部分已经排好序，这部分的每个数都比它左边的最大值要大，同理，如果最左端的一部分排好序，
 *        这每个数都比它右边的最小值小。所以我们从左往右遍历，如果i位置上的数比它左边部分最大值小，则这个数肯定要排序，
 *        就这样找到右端不用排序的部分，同理找到左端不用排序的部分，它们之间就是需要排序的部分,时间复杂度为O(n)
 *      ps:这个解法是真的厉害，需要在实例里面跑debug一步一步调试，观察，才更容易理解
 *
 *
 *
 *
 *
 */


class leetcode_518 {

    public int findUnsortedSubarray(int[] nums){
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]){
                right = i;
            }

            max = Math.max(max, nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]){
                left = i;
            }

            min = Math.min(min, nums[i]);
        }

        return left == right ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        leetcode_518 leetcode_621 = new leetcode_518();
        int[] c = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(leetcode_621.findUnsortedSubarray(c));
    }

}

