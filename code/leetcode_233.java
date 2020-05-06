/**
 * Created by xieli on 2020/5/6.
 */

/*
 * [233] 数字 1 的个数
 *
 * 题目:给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 思路:总体思想就是分类，先求所有数中个位是 1 的个数，再求十位是 1 的个数，再求百位是 1 的个数...
 *      假设 n = xyzdabc，此时我们求千位是 1 的个数，也就是 d 所在的位置。
 *      那么此时有三种情况，
 *          d == 0，那么千位上 1 的个数就是 xyz * 1000
 *          d == 1，那么千位上 1 的个数就是 xyz * 1000 + abc + 1
 *          d > 1，那么千位上 1 的个数就是 xyz * 1000 + 1000
 *
 *
 */

public class leetcode_233 {

    public int countDigitOne(int n) {
        int count = 0;
        for (int k = 1; k <= n; k *= 10) {
            int abc = n % k;
            int xyzd = n / k;
            int d = xyzd % 10;
            int xyz = xyzd / 10;
            count += xyz * k;
            if (d > 1) {
                count += k;
            } else if (d == 1) {
                count += abc + 1;
            }
            //防止溢出
            if (xyz == 0)
                break;
        }
        return count;
    }

}
