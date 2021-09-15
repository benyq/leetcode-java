package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 111
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question111 {
    public static void main(String[] args) {
        Question111 question = new Question111();
        System.out.println(question.minDepth(TreeNode.createTreeNode(3,9,20,null,null,15,7)));
        System.out.println(question.minDepth(TreeNode.createTreeNode(2,null,3,null,4,null,5,null,6)));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }else if (root.left != null) {
            return 1 + minDepth(root.left);
        }else {
            return 1 + minDepth(root.right);
        }
    }
}
