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
 * 题目 27
 * https://leetcode-cn.com/problems/remove-element/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question27 {
    public static void main(String[] args) {
        Question27 question = new Question27();
        int[] nums_1 = new int[]{3,2,2,3};
        System.out.println(question.removeElement(nums_1, 3));
        System.out.println(Arrays.toString(nums_1));
    }

    //快慢指针
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }


}
