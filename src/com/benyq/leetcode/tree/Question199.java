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
public class Question199 {
    public static void main(String[] args) {
        Question199 question = new Question199();
        System.out.println(question.rightSideView(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
        System.out.println(question.rightSideView(TreeNode.createTreeNode(1,2,3,null,5,null,4)));
        System.out.println(question.rightSideView(TreeNode.createTreeNode(1,null,3)));
        System.out.println(question.rightSideView(TreeNode.createTreeNode(1, 2)));
    }

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }

        }
        return res;
    }
}
