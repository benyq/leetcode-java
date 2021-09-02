package com.benyq.leetcode.string;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/02
 * description:
 * 题目 28
 * https://leetcode-cn.com/problems/implement-strstr/
 * KMP 算法没看懂，过几天再回顾一下，妈的
 */

@Problem(status = Status.UNRESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question28 {
    public static void main(String[] args) {
        Question28 question = new Question28();
        System.out.println(question.strStr("hello", "ll"));

    }

    public int strStr(String haystack, String needle) {
        return -1;
    }

}
