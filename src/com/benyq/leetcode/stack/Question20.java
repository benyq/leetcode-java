package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/06
 * description:
 * 题目 20
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question20 {
    public static void main(String[] args) {
        Question20 question = new Question20();
        System.out.println(question.isValid("()[]{}"));
    }


    public boolean isValid(String s) {
        Stack<Character> result = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                result.push('}');
            }else if (c == '(') {
                result.push(')');
            }else if (c == '[') {
                result.push(']');
            }else if (result.isEmpty() || result.peek() != c) {
                return false;
            }else {
                result.pop();
            }
        }
        return result.isEmpty();
    }



}
