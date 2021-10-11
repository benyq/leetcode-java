package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 501
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 二叉搜索树中的众数
 * 中序遍历转化为有序数组
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question501 {
    public static void main(String[] args) {
        Question501 question = new Question501();
        System.out.println(Arrays.toString(question.findMode(TreeNode.createTreeNode(1, 3, 2, 5, 3, null, 9))));
        System.out.println(Arrays.toString(question.findMode(TreeNode.createTreeNode(1, null, 2, 2))));
    }


    TreeNode pre;
    int maxCount = 0;
    int count = 0;
    List<Integer> result;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        result = new ArrayList<>();
        pre = null;
        maxCount = 0;
        count = 0;

        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            result.clear();
            maxCount = count;
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        pre = root;
        traversal(root.right);
    }
}
