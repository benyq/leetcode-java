package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/10/08
 * description:
 * 题目 98
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.MEDIUM)
public class Question98 {
    public static void main(String[] args) {
        Question98 question = new Question98();
        System.out.println(question.isValidBST(TreeNode.createTreeNode(4,2,7,1,3)));
        System.out.println(question.isValidBST(TreeNode.createTreeNode(2,1,3)));
        System.out.println(question.isValidBST(TreeNode.createTreeNode(5,1,4,null,null,3,6)));
        System.out.println(question.isValidBST(TreeNode.createTreeNode(2,2,2)));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,long lower,long upper) {
        if (root == null) return true;
        if (root.val >= upper || root.val <= lower) return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    //错误
    //不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
    public boolean isValidBST_ERROR(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.right == null) {
            if (root.left.val >= root.val) return false;
            else return isValidBST(root.left);
        } else if (root.right != null && root.left == null) {
            if (root.right.val <= root.val) return false;
            else return isValidBST(root.right);
        }else if (root.right != null && root.left != null){
            if (root.right.val <= root.val || root.left.val >= root.val) return false;
            else return isValidBST(root.left) || isValidBST(root.right);
        }

        return true;
    }
}
