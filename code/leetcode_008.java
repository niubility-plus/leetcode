/*
 * [008] 字符串转换整数
 *
 * 题目:请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 *
 *
 * 思路:
 *
 *
 *
 */


class leetcode_008 {

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int idx = 0;
        int n = chars.length;
        boolean negative = false;
        int res = 0;

        //处理空格
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }
        if (idx == n)
            return 0;

        //处理正负号
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }

        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            //感觉这个题解有点吓人，-2147483648虽然会认为越界，但是恰巧返回正确结果
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            idx++;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        leetcode_008 leetcode_008 = new leetcode_008();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

}

