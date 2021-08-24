package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/24
 * description:
 * 题目 454
 * https://leetcode-cn.com/problems/4sum-ii/
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.MEDIUM)
public class Question454 {
    public static void main(String[] args) {
        Question454 question = new Question454();
        System.out.println(question.fourSumCount(new int[]{ 1, 2}, new int[]{-2,-1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
