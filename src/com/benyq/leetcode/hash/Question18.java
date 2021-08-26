package com.benyq.leetcode.hash;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/25
 * description:
 * 题目 18
 * https://leetcode-cn.com/problems/4sum/
 * 这道题需要和 15 一起看
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.EASY)
public class Question18 {
    public static void main(String[] args) {
        Question18 question = new Question18();
        System.out.println(question.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(question.fourSum(new int[]{2,2,2,2,2}, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i+1; j< nums.length;j++) {
                if ( j > i +1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    }else if (sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right-1]) right--;
                        while (right > left && nums[left] == nums[left+1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
