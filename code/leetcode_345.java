/*
 * [345] 反转字符串中的元音字符
 *
 * 题目:编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 *
 * 思路:1.双指针,一个指针从头到尾遍历，一个指针从尾到头遍历
 *        为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 *        因为最多只需要遍历一次，所以时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 *
 *
 *
 *
 *
 */


import java.util.Arrays;
import java.util.HashSet;

class leetcode_345 {

    private static final HashSet<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
    ));

    public String reverseVowels(String s) {
        if (s == null){
            return null;
        }
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j){
            char si = s.charAt(i);
            char sj = s.charAt(j);
            if (!vowels.contains(si)){
                result[i++] = si;
            }else if (!vowels.contains(sj)){
                result[j--] = sj;
            }else {
                result[i++] = sj;
                result[j--] = si;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        leetcode_345 leetcode_167 = new leetcode_345();
    }

}

