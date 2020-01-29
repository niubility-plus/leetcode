/*
 * [141] 判断链表是否存在环
 *
 * 题目:给定一个链表，判断链表中是否有环。
 *
 *
 *
 * 思路:1.双指针,快慢指针,如果有环，两个指针必定会相遇
 *
 *
 *
 *
 */



class leetcode_141 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null){
            if (l1 == l2){
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode_141 leetcode_167 = new leetcode_141();
    }

}

