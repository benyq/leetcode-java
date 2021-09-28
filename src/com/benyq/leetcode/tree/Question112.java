package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/28
 * description:
 * 题目 112
 * https://leetcode-cn.com/problems/path-sum/
 * 路径总和
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question112 {
    public static void main(String[] args) {
        Question112 question = new Question112();
        System.out.println(question.hasPathSum2(TreeNode.createTreeNode(5,4,8,11,null,13,4,7,2,null,null,null,1), 22));
        System.out.println(question.hasPathSum2(TreeNode.createTreeNode(1,2,3), 5));
    }

    //方法一
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    //方法二
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return getSum(root, 0, targetSum);
    }

    private boolean getSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val == targetSum;
        }
        return getSum(root.left, sum + root.val, targetSum) || getSum(root.right, sum + root.val, targetSum);
    }
}
