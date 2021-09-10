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
 * 二叉树的层序遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question102 {
    public static void main(String[] args) {
        Question102 question = new Question102();
        System.out.println(question.levelOrder(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                tmp.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
