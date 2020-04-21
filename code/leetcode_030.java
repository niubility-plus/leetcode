/*
 * [030] 串联所有单词的子串
 *
 * 题目:给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words
 *      中所有单词串联形成的子串的起始位置。注意子串要与 words 中的单词完全匹配，
 *      中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 * 思路:滑动窗口，模板见labuladong 76 题解
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xieli on 2020/4/20.
 */
public class leetcode_030 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> needs = new HashMap<>();
        for (String word : words) {
            needs.put(word, needs.getOrDefault(word, 0) + 1);
        }
        int size = words.length;
        if (size == 0)
            return res;
        int len = words[0].length();

        for (int i = 0; i < len; i++) {
            int left = i;
            int right = left;
            int match = 0;
            HashMap<String, Integer> windows = new HashMap<>();
            while (right < s.length() - len + 1) {
                String rightWord = s.substring(right, right + len);
                if (needs.containsKey(rightWord)) {
                    windows.put(rightWord, windows.getOrDefault(rightWord, 0) + 1);
                    if (windows.get(rightWord).compareTo(needs.get(rightWord)) == 0) {
                        match++;
                    }
                }
                right += len;

                while (match == needs.size()) {
                    if (right - left == len * size) {
                        res.add(left);
                    }
                    String leftWord = s.substring(left, left + len);
                    if (needs.containsKey(leftWord)) {
                        windows.put(leftWord, windows.get(leftWord) - 1);
                        if (windows.get(leftWord) < needs.get(leftWord)) {
                            match--;
                        }
                    }
                    left += len;
                }
            }
        }
        return res;
    }
}
