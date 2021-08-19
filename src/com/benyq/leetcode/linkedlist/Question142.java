package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/16
 * description:
 * 题目 24
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 解析:
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.md
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question142 {
    public static void main(String[] args) {
        Question142 question = new Question142();
        System.out.println(question.detectCycle(ListNode.createNode(1, 2, 6, 3, 4, 5)));
    }

    //傻瓜方式
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        ListNode result = null;
        while (head != null) {
            if (!cache.contains(head)) {
                cache.add(head);
                head = head.next;
            }else {
                result = head;
                break;
            }
        }
        return result;
    }


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //判断链表是否有环
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
