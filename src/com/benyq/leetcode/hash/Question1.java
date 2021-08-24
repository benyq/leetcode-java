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
 * 题目 1
 * https://leetcode-cn.com/problems/two-sum/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question1 {
    public static void main(String[] args) {
        Question1 question = new Question1();
        System.out.println(Arrays.toString(question.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(question.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(question.twoSum(new int[]{3,3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            int ss = target - n;
            map.put(ss, i);
        }
        return new int[]{0, 1};
    }
}
