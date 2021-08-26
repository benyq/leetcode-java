package com.benyq.leetcode.string;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/26
 * description:
 * 题目 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class QuestionOffer05 {
    public static void main(String[] args) {
        QuestionOffer05 question = new QuestionOffer05();
        System.out.println(question.replaceSpace("We are happy."));

    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
