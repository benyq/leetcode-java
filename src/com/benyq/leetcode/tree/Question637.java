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
 * 题目 199
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 二叉树的层序遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question637 {
    public static void main(String[] args) {
        Question637 question = new Question637();
        System.out.println(question.averageOfLevels(TreeNode.createTreeNode(1,2,3,null,5,null,4)));
        System.out.println(question.averageOfLevels(TreeNode.createTreeNode(1,null,3)));
        System.out.println(question.averageOfLevels(TreeNode.createTreeNode(1, 2)));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}
