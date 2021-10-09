package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/10/08
 * description:
 * 题目 617
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 合并二叉树
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question617 {
    public static void main(String[] args) {
        Question617 question = new Question617();
        System.out.println(question.mergeTrees(TreeNode.createTreeNode(1, 3, 2, 5), TreeNode.createTreeNode(2, 1, 3, null, 4, null, 7)));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }

}
