package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/06
 * description:
 * 题目 1047
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question1047 {
    public static void main(String[] args) {
        Question1047 question = new Question1047();
        System.out.println(question.removeDuplicates("abbaca"));
        System.out.println(question.removeDuplicates("abbbaca"));
        System.out.println(question.removeDuplicates("aaa"));
    }


    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty() || deque.peek() != c) {
                deque.push(c);
            }else {
                deque.pop();
            }
        }
        char[] result = new char[deque.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = deque.pop();
        }
        return new String(result);
    }



}
