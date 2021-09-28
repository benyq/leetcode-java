package com.benyq.leetcode.tree;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/28
 * description:
 * 题目 513
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * 找树左下角的值
 * 层序遍历 , 找到最后一层的第一个
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question513 {
    public static void main(String[] args) {
        Question513 question = new Question513();
        System.out.println(question.findBottomLeftValue(TreeNode.createTreeNode(2,1,3)));
        System.out.println(question.findBottomLeftValue(TreeNode.createTreeNode(1,2,3,4,null,5,6,null,null,7)));
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return result;
    }

}
