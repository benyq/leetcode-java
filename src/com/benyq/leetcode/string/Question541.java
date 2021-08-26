package com.benyq.leetcode.string;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/26
 * description:
 * 题目 344
 * https://leetcode-cn.com/problems/reverse-string/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question541 {
    public static void main(String[] args) {
        Question541 question = new Question541();
        System.out.println(question.reverseStr("charse", 2));

    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(s.length() - 1, start + k - 1);
            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
