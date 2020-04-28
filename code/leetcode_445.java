import java.util.Stack;

/**
 * Created by xieli on 2020/4/28.
 */

/*
 * [445] Add Two Numbers II
 *
 * 题目:给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 *      将这两数相加会返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 * 思路:用 stack 保存链表，再从 stack 中取出来，就是数字从低位到高位访问了
 *
 *
 *
 *
 *
 */


public class leetcode_445 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }


}
