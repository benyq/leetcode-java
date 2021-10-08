package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/10/08
 * description:
 * 题目 654
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 最大二叉树
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question654 {
    public static void main(String[] args) {
        Question654 question = new Question654();
        System.out.println(question.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
        System.out.println(question.constructMaximumBinaryTree2(new int[]{3,2,1,6,0,5}));
    }

    // 方法一
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node = new TreeNode(0);
        if (nums.length == 1) {
            node.val = nums[0];
            return node;
        }
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        node.val = maxValue;
        // maxValue = 6
        // maxIndex = 3
        if (maxIndex > 0) {
            int[] newNums = Arrays.copyOf(nums, maxIndex);
            node.left = constructMaximumBinaryTree(newNums);
        }

        if (maxIndex < nums.length - 1) {
            int[] newNums = new int[nums.length - 1 - maxIndex];
            System.arraycopy(nums, maxIndex + 1, newNums, 0, newNums.length);
            node.right = constructMaximumBinaryTree(newNums);
        }

        return node;
    }

    //方法二
    public TreeNode constructMaximumBinaryTree2(int[] nums){
        return create(nums, 0, nums.length);
    }
    private TreeNode create(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = create(nums, leftIndex, maxIndex);
        node.right = create(nums, maxIndex + 1, rightIndex);
        return node;
    }

}
