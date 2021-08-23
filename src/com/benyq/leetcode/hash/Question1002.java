package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/23
 * description:
 * 题目 1002
 * https://leetcode-cn.com/problems/valid-anagram/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question1002 {
    public static void main(String[] args) {
        Question1002 question = new Question1002();
        System.out.println(question.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(question.commonChars(new String[]{"cool","lock","cook"}));
    }

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int[] res = new int[26];
        for (char c : words[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (char c : words[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }
        for (int j = 0; j < 26; j++) {
            if (res[j] > 0) {
                while (res[j] > 0) {
                    result.add("" + (char)('a' + j));
                    res[j]--;
                }
            }
        }
        return result;
    }
}
