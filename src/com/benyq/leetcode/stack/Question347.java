package com.benyq.leetcode.stack;

import com.benyq.leetcode.Problem;
import com.benyq.leetcode.ProblemDifficulty;
import com.benyq.leetcode.Status;

import java.util.*;

/**
 * @author benyq
 * @emil 1520063035@qq.com
 * create at 2021/09/06
 * description:
 * 题目 347
 * https://leetcode-cn.com/problems/top-k-frequent-elements/comments/
 */

@Problem(status = Status.REPEAT, difficulty = ProblemDifficulty.MEDIUM)
public class Question347 {
    public static void main(String[] args) {
        Question347 question = new Question347();
        System.out.println(Arrays.toString(question.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(question.topKFrequent(new int[]{1}, 1)));
    }


    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

}
