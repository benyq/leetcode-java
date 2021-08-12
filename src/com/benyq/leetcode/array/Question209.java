package com.benyq.leetcode.array;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/12
 * description:
 * 题目 704
 * https://leetcode-cn.com/problems/binary-search/
 * 思路: 滑动窗口
 * 中等题型，这个题需要重复练习
 */

@Problem(difficulty = ProblemDifficulty.MEDIUM, status = Status.REPEAT)
public class Question209 {
    public static void main(String[] args) {
        Question209 question = new Question209();
        System.out.println(question.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(question.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(question.minSubArrayLen(11, new int[]{1,2,3,4,5}));
        System.out.println(question.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

    }



    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                int length = i - left + 1;
                result = Math.min(result, length);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
