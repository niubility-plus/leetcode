import java.util.Arrays;
import java.util.Stack;

/*
 * [739] 每日温度
 *
 * 题目:根据每日气温列表，请重新生成一个列表，对应位置的输入是你需要再等待多久
 *      温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 思路:1.从左向右遍历,时间复杂度为O(N*N)
 *      2.从右向左，逆序遍历，利用哈希表的原理，用一个数组next来记录该温度对应
 *        的索引，时间复杂度上为O(N)
 *      3.利用栈，逆序遍历，只存储比当前温度大的索引，时间复杂度上为O(N)
 *      4.逆序 + 跳跃，依然逆序遍历，但是每次的结果利用到了右侧已经计算的结果，
 *        当我们要计算75元素右侧第一个比他大的元素的时候，由于我们逆序遍历，
 *        已经计算了71元素的右侧第一个比他大的元素是76，因此我们可以跳过69，72，
 *        直接将76与75比较即可
 *
 *      PS:个人觉得第四种方法，是最巧妙的，用起来贼爽
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
        int[] result = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next,Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; i--) {
            int warmer_index = Integer.MAX_VALUE;

            for (int j = T[i] + 1; j <= 100 ; j++) {
                //warmer_index记录比当前温度高的索引位置，
                //它等于 next[T[i]+1], next[T[i]+2], ..., next[100] 的最小值
                //最小值才是离T[i]最近的，比当前温度高的索引
                if (next[j] < warmer_index) {
                    warmer_index = next[j];
                }
            }
            if (warmer_index < Integer.MAX_VALUE){
                result[i] = warmer_index - i;
            }

            //记录该温度对应的索引位置
            next[T[i]] = i;
        }
        return result;
    }
}

class Solution_03 {
    public int[] dailyTemperatures(int[] T){
        int len = T.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {

            //栈按照从小到大排序，栈顶是比当前温度大的温度中，最小温度的索引
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}

class Solution_04 {
    public int[] dailyTemperatures(int[] T){
        int len = T.length;
        int[] result = new int[len];

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j += result[j]) {
                if (T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }

                //当result[j]为0时，说明后面没有比T[j]，即T[j-1]，也就是T[i]更高的温度
                //如果不跳出的话，这里就是一个无限死循环
                if (result[j] == 0)
                    break;
            }
        }
        return result;
    }
}
