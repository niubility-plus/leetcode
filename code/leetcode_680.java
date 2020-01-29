/*
 * [680] 回文字符串
 *
 * 题目:可以删除一个字符，判断是否能构成回文字符串。
 *
 *
 *
 * 思路:1.双指针,令一个指针从左到右遍历，一个指针从右到左遍历，这两个指针同时移动一个位置，
 *        每次都判断两个指针指向的字符是否相同，如果都相同，字符串才是具有左右对称性质的回文字符串
 *        在试着删除字符时，我们既可以删除左指针指向的字符，也可以删除右指针指向的字符。
 *
 *
 *
 */


import java.util.Arrays;
import java.util.HashSet;

class leetcode_680 {

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_680 leetcode_167 = new leetcode_680();
    }

}

