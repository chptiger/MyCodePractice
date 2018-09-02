package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/*Description
        Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack.
        If the stack is empty, min() should return -1.

        pop() - remove and return the top element, if the stack is empty, return -1

        push(int element) - push the element to top
        top() - return the top element without remove it, if the stack is empty, return -1
        min() - return the current min value in the stack.*/
public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        // write your solution here
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        Integer result = stack.pollFirst();

        if (minStack.peekFirst() == result) {
            minStack.pollFirst();
        }

        return result;
    }

    public void push(Integer element) {
        stack.offerFirst(element);
        if (minStack.isEmpty() || minStack.peekFirst() >= element) {
            minStack.offerFirst(element);
        }
    }

    public Integer top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }

    @Test
    public void test_minStack(){
        StackWithMin stack = new StackWithMin();
        Assert.assertEquals((Integer)(-1),stack.min());
        stack.push(2);
        Assert.assertEquals((Integer)(2),stack.min());
        stack.push(3);
        Assert.assertEquals((Integer)(2),stack.min());
        stack.push(1);
        Assert.assertEquals((Integer)(1),stack.min());
    }
}
