
/*
 * [739] 每日温度
 *
 * 题目:根据每日气温列表，请重新生成一个列表，对应位置的输入是你需要再等待多久
 *      温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 思路:1.从左向右遍历
 *      2.
 *
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}

class Solution_02 {
    public int[] dailyTemperatures(int[] T) {
        return null;
    }
}