/*
 * [076] 最小覆盖字串
 *
 * 题目:给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 *
 *
 * 思路:滑动窗口
 *      1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，
 *          把索引闭区间 [left, right] 称为一个「窗口」。
 *      2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串
 *          符合要求（包含了 T 中的所有字符）。
 *      3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，
 *          直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次
 *          增加 left，我们都要更新一轮结果。
 *      4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
 *
 *
 *
 */


import java.util.HashMap;

/**
 * Created by xieli on 2020/4/20.
 */
public class leetcode_076 {

    public String minWindow(String s, String t) {
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).compareTo(needs.get(c)) == 0) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = right - left;
                }
                char c1 = s.charAt(left);
                if (needs.containsKey(c1)) {
                    windows.put(c1, windows.getOrDefault(c1, 1) - 1);
                    if (windows.get(c1) < needs.get(c1)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
