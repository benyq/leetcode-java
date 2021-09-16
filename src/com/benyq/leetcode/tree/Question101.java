package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 101
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question101 {
    public static void main(String[] args) {
        Question101 question = new Question101();
        System.out.println(question.isSymmetric(TreeNode.createTreeNode(4,2,7,1,3,6,9)));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }
}
