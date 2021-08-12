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
 * 数组的二分查找
 */


@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question704 {
    public static void main(String[] args) {
        Question704 question = new Question704();
        System.out.println(question.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(question.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(question.search(new int[]{-1,3,4}, 4));
        System.out.println(question.search(new int[]{-1}, -1));
    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        //  +1 / -1 不能忘记
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            }  else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
