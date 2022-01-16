package acwing.Vol1to100;

import java.util.Stack;

public class AcWing41 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();

            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
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
}
