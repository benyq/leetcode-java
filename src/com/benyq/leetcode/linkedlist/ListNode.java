package com.benyq.leetcode.linkedlist;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
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
