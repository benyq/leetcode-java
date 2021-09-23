package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 257
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 二叉树的所有路径
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question257 {
    public static void main(String[] args) {
        Question257 question = new Question257();
        System.out.println(question.binaryTreePaths(TreeNode.createTreeNode(1,2,3,null,5)));
        System.out.println(question.binaryTreePaths(TreeNode.createTreeNode(1)));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        solve(root, "", result);
        return result;
    }

    //前序遍历
    private void solve(TreeNode root, String cur, List<String> result) {
        //终止条件
        if (root == null) {
            return;
        }
        cur += root.val;
        //叶子节点
        if (root.left == null && root.right == null) {
            result.add(cur);
        }else {
            solve(root.left, cur+ "->", result);
            solve(root.right, cur+ "->", result);
        }
    }
}
