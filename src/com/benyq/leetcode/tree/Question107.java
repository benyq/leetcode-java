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
 * 题目 107
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 二叉树的层序遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question107 {
    public static void main(String[] args) {
        Question107 question = new Question107();
        System.out.println(question.levelOrderBottom(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        LinkedList<List<Integer>> res = new LinkedList<>();
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
            res.addFirst(tmp);
        }
        return res;
    }
}
