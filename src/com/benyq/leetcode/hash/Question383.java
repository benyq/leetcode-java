package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/25
 * description:
 * 题目 383
 * https://leetcode-cn.com/problems/ransom-note/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question383 {
    public static void main(String[] args) {
        Question383 question = new Question383();
        System.out.println(question.canConstruct("a", "b"));
        System.out.println(question.canConstruct("aa", "ab"));
        System.out.println(question.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c-'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            chars[c-'a'] -= 1;
            if (chars[c-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
