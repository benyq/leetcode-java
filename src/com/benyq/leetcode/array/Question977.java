package com.benyq.leetcode.array;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/12
 * description:
 * 题目 977
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 双指针
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question977 {
    public static void main(String[] args) {
        Question977 question = new Question977();
        System.out.println(Arrays.toString(question.sortedSquares(new int[]{-1,0,3,5,9,12})));
        System.out.println(Arrays.toString(question.sortedSquares(new int[]{-7,-3,2,3,11})));

    }


    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int pos = nums.length - 1;

        while (start <= end) {
            int sumStart = nums[start] * nums[start];
            int sumEnd = nums[end] * nums[end];
            if (sumStart >= sumEnd) {
                result[pos--] = sumStart;
                start++;
            }else {
                result[pos--] = sumEnd;
                end--;
            }
        }
        return result;
    }
}
