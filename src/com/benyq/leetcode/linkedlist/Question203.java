package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.Arrays;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/13
 * description:
 * 题目 203
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 主要是添加一个 虚拟 head 节点
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question203 {
    public static void main(String[] args) {
        Question203 question = new Question203();
        System.out.println(question.removeElements(ListNode.createNode(1,2,6,3,4,5,6), 6));
        System.out.println(question.removeElements2(ListNode.createNode(1,2,6,3,4,5,6), 6));
        System.out.println(question.removeElements(ListNode.createNode(7,7,7,7), 7));
        System.out.println(question.removeElements(ListNode.createNode(), 1));

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode virtual = new ListNode(-1);
        virtual.next = head;
        ListNode cur = virtual;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return virtual.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dump = new ListNode(0, head);
        ListNode cur = dump;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dump.next;
    }
}
