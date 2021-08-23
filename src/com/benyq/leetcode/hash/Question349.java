package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/23
 * description:
 * 题目 349
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question349 {
    public static void main(String[] args) {
        Question349 question = new Question349();
        System.out.println(Arrays.toString(question.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(question.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> res = new HashSet();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            if (set1.contains(n)) {
                res.add(n);
            }
        }
        int[] result = new int[res.size()];

        int index = 0;
        for (int n : res) {
            result[index++] = n;
        }

        return result;

    }
}
