package pers.tavish.leetcode.easy;

/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:

- Methods pop, top and getMin operations will always be called on non-empty stacks.

 */

import java.util.NoSuchElementException;

public class MinStack {

    private final ListNode beginMaker;
    private final ListNode endMaker;

    private int min;

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public MinStack() {
        beginMaker = new ListNode(Integer.MIN_VALUE);
        endMaker = new ListNode(Integer.MAX_VALUE);
        beginMaker.next = endMaker;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = beginMaker.next;
        beginMaker.next = node;
        min = Math.min(x, min);
    }

    public void pop() {
        check();
        boolean popMin = min == beginMaker.next.val;
        beginMaker.next = beginMaker.next.next;
        if (popMin) {
            min = Integer.MAX_VALUE;
            ListNode curr = beginMaker.next;
            while (curr != endMaker) {
                min = Math.min(curr.val, min);
                curr = curr.next;
            }
        }
    }

    public int top() {
        check();
        return beginMaker.next.val;
    }

    public int getMin() {
        check();
        return min;
    }

    private void check() {
        if (beginMaker.next == endMaker) {
            throw new NoSuchElementException();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
