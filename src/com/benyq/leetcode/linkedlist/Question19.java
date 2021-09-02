package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 19
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question19 {
    public static void main(String[] args) {
        Question19 question = new Question19();
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 1));
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 2));
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 3));
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 4));
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 5));
        System.out.println(question.removeNthFromEnd(ListNode.createNode(1, 2, 3, 4, 5, 6), 6));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            if (n-- > 0) {
                continue;
            }
            slow = slow.next;
        }

        if (n == 1) {
            return head.next;
        }
        //移除节点
        slow.next = slow.next.next;
        return head;
    }
}
