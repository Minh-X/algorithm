package algorithm7.leetcode.队栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: permission
 * @Date: 2023/2/5 17:16
 * @Version: 1.0
 * @ClassName: LC155
 * @Description: 155. 最小栈
 */
public class LC155 {


class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }
        minStack.push(Math.min(val, minStack.peek()));
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



}
