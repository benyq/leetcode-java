package com.benyq.leetcode.tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author benyq
 * @date 2021/8/19
 * @email 1520063035@qq.com
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode createTreeNode(Integer... nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        for (int i = 1; i < nums.length; i += 2) {
            int size = queue.size();
            if (size == 0) {
                break;
            }
            TreeNode cur = queue.poll();
            if (nums[i] != null) {
                TreeNode left = new TreeNode(nums[i]);
                cur.left = left;
                queue.add(left);
            }

            if (i < nums.length - 1 && nums[i + 1] != null) {
                TreeNode right = new TreeNode(nums[i + 1]);
                cur.right = right;
                queue.add(right);
            }
        }

        return head;
    }
}