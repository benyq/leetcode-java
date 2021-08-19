package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 24
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question24 {
    public static void main(String[] args) {
        Question24 question = new Question24();
        System.out.println(question.swapPairs(ListNode.createNode(1, 2, 6, 3, 4, 5)));
        System.out.println(question.swapPairs(ListNode.createNode(2, 3)));
        System.out.println(question.swapPairs(ListNode.createNode(2, 3, 1)));
        System.out.println(question.swapPairs(ListNode.createNode(2)));
        System.out.println(question.swapPairs(ListNode.createNode()));

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dump = new ListNode(0, head);

        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = dump;

        while (next != null) {

            //将 cur 与 next 节点交换，形成 pre -> next -> cur -> next->next 形态
            ListNode temp = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = temp;

            //移动 pre、cur、next 节点
            pre = cur;
            cur = temp;
            if (temp == null) {
                break;
            }
            next = temp.next;
        }

        return dump.next;
    }

    //递归方式
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsRecursion(next.next);
        next.next = head;
        return next;
    }
}
