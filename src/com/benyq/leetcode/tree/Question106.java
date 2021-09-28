package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/28
 * description:
 * 题目 106
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 路径总和
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.MEDIUM)
public class Question106 {
    public static void main(String[] args) {
        Question106 question = new Question106();
        System.out.println(question.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        //分割
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(inorder, inLeft, rootIndex, postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = buildTree(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inLeft), postRight - 1);

        return root;
    }
}
