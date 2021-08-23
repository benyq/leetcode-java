package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;
import com.benyq.leetcode.tree.TreeNode;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/23
 * description:
 * 题目 242
 * https://leetcode-cn.com/problems/valid-anagram/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question242 {
    public static void main(String[] args) {
        Question242 question = new Question242();
        System.out.println(question.isAnagram("anagram", "nagaram"));
        System.out.println(question.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a'] -= 1;
        }
        for (int c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
