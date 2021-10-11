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
 * 题目 530
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 二叉搜索树的最小绝对差
 * 中序遍历转化为有序数组
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question530 {
    public static void main(String[] args) {
        Question530 question = new Question530();
        System.out.println(question.getMinimumDifference(TreeNode.createTreeNode(1,3,2,5,3,null,9)));
        System.out.println(question.getMinimumDifference(TreeNode.createTreeNode(0, -1)));
    }

    TreeNode pre = null;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root){
        if(root==null)return;
        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }

}
