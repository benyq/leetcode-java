package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/03
 * description:
 * 题目 225
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
    }


    private static class MyStack {

        private Queue<Integer> input = new LinkedList<>();
        private Queue<Integer> out = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            out.add(x);
            while (!input.isEmpty()) {
                out.add(input.poll());
            }
            Queue<Integer> temp = out;
            out = input;
            input = temp;
        }

        public int pop() {
            return input.poll();
        }

        public int top() {
            return input.peek();
        }

        public boolean empty() {
            return input.isEmpty();
        }
    }



}
