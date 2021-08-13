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
 * 题目 59
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 这个题需要重复练习
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question59 {
    public static void main(String[] args) {
        Question59 question = new Question59();
        question.arrayToString(question.generateMatrix(3));
    }


    //处理时 一圈一圈地处理
    //关键是区间。这个区间是 左闭右开
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 1;
        while (index <= n * n) {
            //从左到右
            for (int j = left; j <= right; j++) {
                result[top][j] = index++;
            }
            top++;
            //从上到下
            for (int j = top; j <= bottom; j++) {
                result[j][right] = index++;
            }
            right--;
            //从左到右
            for (int j = right; j >= left; j--) {
                result[bottom][j] = index++;
            }
            bottom--;
            //从下到上
            for (int j = bottom; j >= top; j--) {
                result[j][left] = index++;
            }
            left++;
        }

        return result;
    }

    private void arrayToString(int[][] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < nums.length; i++) {
            sb.append(Arrays.toString(nums[i]));
        }

        sb.append(']');
        System.out.println(sb);
    }
}
