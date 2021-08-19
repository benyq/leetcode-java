package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 104
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 求二叉树的最大深度
 * 我把它放在这是因为我想练习递归
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question104 {
    public static void main(String[] args) {
        Question104 question = new Question104();
        System.out.println(question.maxDepth(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
