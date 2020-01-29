/*
 * [633] 两数平方和
 *
 * 题目:判断一个非负整数是否为两个整数的平方和。
 *
 *
 *
 *
 * 思路:1.双指针,指向较小元素的指针从头到尾遍历，指向较大元素的指针从尾到头遍历
 *        设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
 *        因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。只使用了两个额外变量，空间复杂度为 O(1)。
 *
 *
 *
 *
 *
 */


class leetcode_633 {

    public boolean judgeSquareSum(int c) {
        if (c < 0){
            return false;
        }
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j){
            int powSum = i * i + j * j;
            if (powSum == c){
                return true;
            }else if (powSum < c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode_633 leetcode_167 = new leetcode_633();
    }

}

