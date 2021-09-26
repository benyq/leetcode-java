package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 102
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 左叶子之和
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question404 {
    public static void main(String[] args) {
        Question404 question = new Question404();
        System.out.println(question.sumOfLeftLeaves(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        return midValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.left != null) deque.offer(node.left);
            if (node.right != null) deque.offer(node.right);
        }
        return result;
    }
}
