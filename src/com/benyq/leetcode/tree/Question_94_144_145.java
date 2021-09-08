package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 94 / 144/ 145
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 二叉树遍历
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question_94_144_145 {
    public static void main(String[] args) {
        Question_94_144_145 question = new Question_94_144_145();
        System.out.println(question.inorderTraversal(TreeNode.createTreeNode(1,null,2,3)));
        System.out.println(TreeNode.createTreeNode(1,null,2,3));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}
