package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/10
 * description:
 * 题目 222
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 完全二叉树的节点个数
 * 完全二叉树：它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧
 *          如果根节点的左子树深度等于右子树深度，则说明左子树为满二叉树。
 *          如果根节点的左子树深度大于右子树深度，则说明右子树为满二叉树
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question222 {
    public static void main(String[] args) {
        Question222 question = new Question222();
        System.out.println(question.countNodes2(TreeNode.createTreeNode(1,2,3,4,5,6)));
        System.out.println(question.countNodes2(TreeNode.createTreeNode()));
        System.out.println(question.countNodes2(TreeNode.createTreeNode(1)));
    }

    //这个是用普通的方法，没用到完全二叉树性质
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return sum;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        //右子树是满二叉树
        if (leftDepth == rightDepth) {
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes2(root.right);
        }
        return (1 << rightDepth) + countNodes2(root.left);
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
