package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Stack;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/06
 * description:
 * 题目 150
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/comments/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question150 {
    public static void main(String[] args) {
        Question150 question = new Question150();
        System.out.println(question.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(question.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(question.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(0);
            if (!isOpe(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            }else if (c == '-') {
                stack.push(-stack.pop() + stack.pop());
            }else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            }else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.pop();
    }

    private boolean isOpe(String s) {
        return s.length() == 1 && s.charAt(0) <'0' || s.charAt(0) >'9';
    }
}
