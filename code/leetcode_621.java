/*
 * [621] 任务调度器
 *
 * 题目:给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母
 *      表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单
 *      位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。然
 *      而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时
 *      间内 CPU 在执行不同的任务，或者在待命状态。
 *      你需要计算完成所有任务所需要的最短时间。
 *
 * 思路:1.排序+贪心,时间复杂度为O(n),n为字符数组的长度
 *      a.将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
 *      b.对数组进行排序，优先排列个数（count）最大的任务，
 *        如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
 *      c.再排序下一个任务，如果下一个任务B个数和最大任务数一致，
 *        则retCount++ ==> A->B->X->A->B->X->A->B
 *      d.如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
 *
 *      2.
 *
 *
 *
 */

import java.util.Arrays;

class leetcode_621 {

    public int leastInterval(char[] tasks, int n){
        if (tasks.length <= 1 || n < 1)
            return tasks.length;
        int[] map = new int[26];
        for (char c : tasks){
            map[c - 'A']++;
        }

        Arrays.sort(map);

        int max = map[25];
        int ans = (max - 1) * (n + 1) + 1;

        int i = 24;
        while (i >= 0 && map[i] == max){
            ans++;
            i--;
            if (map[i] == 0)
                break;
        }

        return Math.max(ans, tasks.length);
        //如果按照最长的排完之后，后面还有剩下的没有排的，比如字符串序列式AAABBBCCCD，然后n=2的话，
        // 那拍好就是ABCABCABCD，按照公式计算出来的结果是(3-1)*(3)+1+2=9，但是实际的序列应该是ABCABCABCD，
        // 应该是10，所以通过求max来补充掉这个正好全排列但是还有多出去的情况
    }

    public static void main(String[] args) {
        leetcode_621 leetcode_621 = new leetcode_621();
        char[] c = {'A','A','A','B','B','B'};
        System.out.println(leetcode_621.leastInterval(c,2));
    }

}

