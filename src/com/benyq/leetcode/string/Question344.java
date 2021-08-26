package com.benyq.leetcode.string;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;
import com.benyq.leetcode.linkedlist.ListNode;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/26
 * description:
 * 题目 344
 * https://leetcode-cn.com/problems/reverse-string/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question344 {
    public static void main(String[] args) {
        Question344 question = new Question344();
        char[] chars = "qwertyu".toCharArray();
        question.reverseString(chars);
        System.out.println(chars);

        chars = "asdfghjk".toCharArray();
        question.reverseString(chars);
        System.out.println(chars);
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];  //构造 a ^ b 的结果，并放在 a 中
            s[right] ^= s[left];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[left] ^= s[right];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            left++;
            right--;
        }
    }
}
