package com.benyq.leetcode.linkedlist;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import javax.swing.*;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/08/13
 * description:
 * 题目 707
 * https://leetcode-cn.com/problems/design-linked-list/
 */

@Problem(status = Status.RESOLVED, difficulty = ProblemDifficulty.MEDIUM)
public class Question707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.dump.next);
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);
        System.out.println(linkedList.dump.next);
    }


    static class MyLinkedList {
        int size = 0;
        public ListNode dump;

        public MyLinkedList() {
            dump = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index > size - 1) {
                return -1;
            }
            ListNode cur = dump.next;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = dump.next;
            dump.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode cur = dump;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            ListNode node = new ListNode(val);
            ListNode cur = dump;
            while (index-- > 0) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode cur = dump;
            while (index-- > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }
}
