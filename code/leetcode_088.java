/*
 * [88] 归并两个有序数组
 *
 * 题目:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *
 *
 * 思路:1.双指针
 *
 *
 *
 */


class leetcode_088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0){
            if (index1 < 0){
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0){
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] < nums2[index2]){
                nums1[indexMerge--] = nums2[index2--];
            } else {
                nums1[indexMerge--] = nums1[index1--];
            }
        }
    }

    //灵魂画师牧码版本，思路一模一样，更简洁易懂
    public void merge_pro(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);
    }

    public static void main(String[] args) {
        leetcode_088 leetcode_167 = new leetcode_088();
    }

}

