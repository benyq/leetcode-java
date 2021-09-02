package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.HashSet;
import java.util.Set;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/02
 * description:
 * 面试题 02.07. 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.EASY)
public class Question0207 {
    public static void main(String[] args) {
        Question0207 question = new Question0207();
        System.out.println(question.getIntersectionNode(ListNode.createNode(5,0,1,8,4,5), ListNode.createNode(4,1,8,4,5)));
        System.out.println(question.getIntersectionNode(ListNode.createNode(0,9,1,2,4), ListNode.createNode(3,2,4)));
    }

    //hash 方式
    public ListNode getIntersectionNode(ListNode headB, ListNode headA) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode2(ListNode headB, ListNode headA) {
        int lenA = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode tempB = headB;
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff -- > 0) {
                headA = headA.next;
            }
        }else {
            while (diff -- > 0) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headB = headB.next;
            headA = headA.next;
        }

        return null;
    }
}
