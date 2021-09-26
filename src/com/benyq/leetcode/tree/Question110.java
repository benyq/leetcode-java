package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 110
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 平衡二叉树
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question110 {
    public static void main(String[] args) {
        Question110 question = new Question110();
        System.out.println(question.isBalanced(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
        System.out.println(question.isBalanced(TreeNode.createTreeNode()));
        System.out.println(question.isBalanced(TreeNode.createTreeNode(1,2,2,3,3,null,null,4,4)));
    }

    //自上向下
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && (isBalanced(root.left) && isBalanced(root.right));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }


    //自下向上
    public boolean isBalanced2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth < 0) return -1;
        int rightDepth = getDepth(root.right);
        if (rightDepth < 0) return -1;
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = depth(root.left);
        if (leftD < 0) return -1;
        int rightD = depth(root.right);
        if (rightD < 0) return -1;
        return Math.abs(leftD - rightD) > 1 ? -1 : 1 + Math.max(leftD, rightD);
    }
}
