package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/13
 * description:
 * 题目 206
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 翻转链表，不额外创建链表
 */

@Problem(status = Status.UNRESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question206 {
    public static void main(String[] args) {
        Question206 question = new Question206();
        System.out.println(question.reverseList2(ListNode.createNode(1, 2, 6)));
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;
        cur.next = prev;

        return reverse(cur, temp);
    }
}
