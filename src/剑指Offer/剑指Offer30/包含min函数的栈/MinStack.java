/*
剑指 Offer 30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.


提示：

各函数的调用总次数不超过 20000 次
###解题思路
设计
执行用时：21 ms, 在所有 Java 提交中击败了30.91%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了100.00%的用户
 */
package 剑指Offer.剑指Offer30.包含min函数的栈;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) min.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) min.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */