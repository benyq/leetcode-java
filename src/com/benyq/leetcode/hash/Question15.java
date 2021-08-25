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
 * 题目 15
 * https://leetcode-cn.com/problems/3sum/
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.EASY)
public class Question15 {
    public static void main(String[] args) {
        Question15 question = new Question15();
        System.out.println(question.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(question.threeSum(new int[]{}));
        System.out.println(question.threeSum(new int[]{0}));
    }

    //因为要求不能重复，所以 map 的方式就不行了
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //left后面或者right前面相同的值需要去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
