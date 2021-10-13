package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/10/13
 * description:
 * 题目 236
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 二叉树的最近公共祖先
 * 后序遍历
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.MEDIUM)
public class Question236 {
    public static void main(String[] args) {
        Question236 question = new Question236();

        //3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        System.out.println(question.lowestCommonAncestor(root, root.left, root.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        if(leftTree == null){  // 两个节点全部在右子树上
            return rightTree;
        }else if (rightTree == null){  // 两个节点全部在左子树上
            return leftTree;
        }
        return root;  // 两个节点分别在左右子树上，root就是最近公共祖先
    }
}
