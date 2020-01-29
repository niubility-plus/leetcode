/*
 * [167] 两数之和 II - 输入有序数组
 *
 * 题目:给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 *      函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 *
 *
 *
 * 思路:1.双指针,指向较小元素的指针从头到尾遍历，指向较大元素的指针从尾到头遍历
 *        组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 *
 *
 *
 *
 *
 */


class leetcode_167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null){
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if (sum == target){
                return new int[]{i + 1, j + 1};
            }else if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        leetcode_167 leetcode_167 = new leetcode_167();
    }

}

