/*
 * [400] Nth_Digit
 *
 * 题目:在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 *
 *
 * 思路:比如输入的 n 是 365：
 *      1.经过第一步计算我们可以得到第 365 个数字表示的数是三位数，n=365-9-90x2=176n=365−9−90×2=176，digtis = 3。
 *          这时 n=176n=176 表示目标数字是三位数中的第 176176 个数字。
 *      2.我们设目标数字所在的数为 number，计算得到 number=100+176/3=158，idx 是目标数字在 number 中的索引，如果
 *           idx = 0，表示目标数字是 number - 1 中的最后一个数字。（感谢@1m188 更正为 number-1）
 *      3.根据步骤2，我们可以计算得到 idx = n % digits = 176 % 3 = 2，说明目标数字应该是 number = 158 中的第二个数字，
 *          即输出为 5。
 *
 *
 *
 */


class leetcode_400 {

    public int findNthDigit(int n) {
        // 计算该数字由几位数字组成，由1位：digits = 1；2位：digits = 2...
        long base = 9, digits = 1;
        while (n - base * digits > 0) {
            n -= base * digits;
            base *= 10;
            digits++;
        }

        // 计算真实代表的数字是多少
        long idx = n % digits;// 注意由于上面的计算，n现在表示digits位数的第n个数字
        if (idx == 0) {
            idx = digits;
        }

        // 从真实的数字中找到我们想要的那个数字
        long sum = 1;
        for (int k = 1; k < digits; k++) {
            sum *= 10;
        }
        sum += (idx == digits) ? (n / digits - 1) : (n / digits);

        for (long i = idx; i < digits; i++) {
            sum /= 10;
        }

        return (int) sum % 10;
    }

}

