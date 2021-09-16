package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.*;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 226
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树，递归与层序遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question226 {
    public static void main(String[] args) {
        Question226 question = new Question226();
        System.out.println(question.invertTree(TreeNode.createTreeNode(4,2,7,1,3,6,9)));
        System.out.println(question.invertTree2(TreeNode.createTreeNode(4,2,7,1,3,6,9)));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                if (node.right != null) deque.offer(node.right);
                if (node.left != null) deque.offer(node.left);
            }
        }

        return root;
    }
}
