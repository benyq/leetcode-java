package com.benyq.leetcode.string;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/31
 * description:
 * 题目 151
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question151 {
    public static void main(String[] args) {
        Question151 question = new Question151();
        System.out.println(question.reverseWords("the sky is blue"));
        System.out.println(question.reverseWords("  hello world  "));
        System.out.println(question.reverseWords("a good   example"));
        System.out.println(question.reverseWords("      Bob    Loves  Alice   "));
        System.out.println(question.reverseWords("Alice does not even like bob"));
        System.out.println(question.reverseWords("EPY2giL"));
    }

    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();

        char[] result = new char[chars.length];

        int index = 0;
        int length = 0;
        int totalLength = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                length++;
            }else {
                for (int j = i + 1; j < i + length + 1; j++) {
                    result[index++] = chars[j];
                }
                if (length > 0) {
                    totalLength += length + 1;
                    result[index++] = ' ';
                }
                length = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            result[index++] = chars[i];
        }
        totalLength += length;
        return new String(result, 0, totalLength);
    }

}
