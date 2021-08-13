package com.benyq.leetcode.linkedlist;



/**
 * @author benyq
 * @date 2021/8/13
 * @email 1520063035@qq.com
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode createNode(int... nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            pre.next = node;
            pre = node;
        }
        return head.next;
    }
}
