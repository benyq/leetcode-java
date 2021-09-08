package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/06
 * description:
 * 题目 239
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.HARD)
public class Question239 {
    public static void main(String[] args) {
        Question239 question = new Question239();
        System.out.println(Arrays.toString(question.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
//        System.out.println(Arrays.toString(question.maxSlidingWindow(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(question.maxSlidingWindow(new int[]{1,-1}, 1)));
//        System.out.println(Arrays.toString(question.maxSlidingWindow(new int[]{9,11}, 2)));
//        System.out.println(Arrays.toString(question.maxSlidingWindow(new int[]{4,-2}, 2)));
    }


    //超时
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        int[] result = new int[nums.length - k + 1];
//        int index = 0;
//
//        //先算出 0 ~ k - 1 的 最大值
//        int max = maxNum(nums, k, 0);
//        result[index++] = max;
//
//        int start = 0;
//        int end = start + k - 1;
//
//        while (end < nums.length - 1) {
//            if (nums[start] == max) {
//                max =  maxNum(nums, k, ++start);
//                end++;
//                result[index++] = max;
//                continue;
//            }
//            max = Math.max(max, nums[++end]);
//            start++;
//            result[index++] = max;
//        }
//
//        return result;
//    }
//
//    private int maxNum(int[] nums, int k, int start) {
//        int[] startArray = new int[k];
//        System.arraycopy(nums, start, startArray, 0, k);
//        Arrays.sort(startArray);
//        return startArray[k - 1];
//    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        // [1,3,-1,-3,5,3,6,7] 3
        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pop();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pop();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
