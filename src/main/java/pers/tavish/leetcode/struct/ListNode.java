package pers.tavish.leetcode.struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int... vals) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return next != null ? val + "->" + next.toString() : val + "";
    }
}
