package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/28
 * description:
 * 题目 105
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 */

@Problem(status = Status.UNRESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question105 {
    public static void main(String[] args) {
        Question105 question = new Question105();
        System.out.println(question.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {

        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, preLeft + 1, preLeft + (rootIndex - inLeft), inorder, inLeft, rootIndex - 1);
        // postRight - 1 不能忘，因为最后一个已经是rootVal
        root.right = buildTree(preorder, preLeft + (rootIndex - inLeft) + 1, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }
}
