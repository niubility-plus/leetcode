/*
 * [524] 通过删除字母匹配到字典里最长单词(最长子序列)
 *
 * 题目:给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串
 *      的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，
 *      则返回空字符串。
 *
 *
 * 思路:1.双指针,利用两个指针i,j,一个指向s字符串,一个指向str字符串，每一次查找过程中,
 *        i依次后移，若i,j对应的两个字符相等，则j后移，如果j可以移到str.length()，那么说明
 *        str中对应的字符s中都有，即s中删除一些字符后，可以得到str字符串，最后一步就是比较当前的结果字符与找到的str字符
 *
 *
 *
 */


import java.util.List;

class leetcode_524 {

    public String findLongestWord(String s, List<String> d) {
        String resulut = "";
        for (String str : d) {
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j))
                    j++;
                if (j == str.length()) {
                    if (str.length() > resulut.length() ||
                            (str.length() == resulut.length() && resulut.compareTo(str) > 0)) {
                        resulut = str;
                    }
                }
            }
        }
        return resulut;
    }

    public static void main(String[] args) {
        leetcode_524 leetcode_524 = new leetcode_524();
    }

}

