/*
 * [647] 回文子串
 *
 * 题目:给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *      具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 思路:1.暴力循环遍历，两个指针，从0到len，双重循环,时间复杂度为O(n^3)
 *      2.从中心向两边扩散，需要考虑奇偶个数的情况，时间复杂度为O(n^2)
 *      3.第二种做法的动态规划做法，时间复杂度为O(n^2)
 *
 */

class leetcode_647 {

    public static void main(String[] args) {
        leetcode_647 test = new leetcode_647();
        System.out.println(test.countSubstrings("aaa"));
        System.out.println(test.countSubstrings("abc"));

        System.out.println(test.countSubstrings_02("abc"));
        System.out.println(test.countSubstrings_03("abc"));
    }

        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (isPalindrome(s, i, j))
                        count++;
                }
            }
            return count;
        }

        private boolean isPalindrome(String s, int start, int end){
            while (start <= end){
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                }else {
                    return false;
                }
            }
            return true;
        }

        public int countSubstrings_02(String s){
            int res = 0;


            //要考虑奇偶个数的情况
            for (int i = 0; i < s.length(); i++) {
                res += countSegment(s, i, i);
                res += countSegment(s, i, i + 1);
            }

            return res;
        }

        private int countSegment(String s, int start, int end){
            int count = 0;

            while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
                count++;
            }

            return count;
        }

        public int countSubstrings_03(String s){
            int ans = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (i == j)
                        dp[i][j] = true;
                    else
                        dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j <= i + 1 || dp[i+1][j-1]);
                        //j <= i + 1 表达的是两个字符中间没有其他字符，dp[i+1][j-1] 是去判定中间的字符是否是回文字符
                    if (dp[i][j])
                        ans++;
                }
            }
            return ans;
        }

}

