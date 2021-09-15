package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 515
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * 二叉树的层序遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question515 {
    public static void main(String[] args) {
        Question515 question = new Question515();
        System.out.println(question.largestValues(TreeNode.createTreeNode(1,3,2,5,3,null,9)));
        System.out.println(question.largestValues(TreeNode.createTreeNode(1,2,3)));
        System.out.println(question.largestValues(TreeNode.createTreeNode(1,null,2)));
        System.out.println(question.largestValues(TreeNode.createTreeNode(0, -1)));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(max);
        }

        return result;
    }

}
