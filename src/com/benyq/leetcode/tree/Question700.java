package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/10/08
 * description:
 * 题目 700
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 二叉搜索树中的搜索
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.EASY)
public class Question700 {
    public static void main(String[] args) {
        Question700 question = new Question700();
        System.out.println(question.searchBST(TreeNode.createTreeNode(4,2,7,1,3), 2));
    }

    //利用二叉搜索树性质
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return null;
    }

}
