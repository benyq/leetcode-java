package com.benyq.leetcode;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author benyq
 * @date 2021/10/13
 * @email 1520063035@qq.com
 * 这个是用来回顾的，找到不同 解决类型的题目
 */
public class ReviewProblem {

    public static void main(String[] args) {
        List<Class<?>> classList =  ClassUtil.getClasses(ReviewProblem.class.getPackage().getName());
        List<Class<?>> classUnResolved = new ArrayList<>();
        List<Class<?>> classRepeat = new ArrayList<>();
        List<Class<?>> classSolved = new ArrayList<>();
        for (Class<?> clz : classList) {
            Problem problemAnnotation = clz.getAnnotation(Problem.class);
            if (problemAnnotation != null) {
                if (problemAnnotation.status() == Status.UNRESOLVED) {
                    classUnResolved.add(clz);
                }else if (problemAnnotation.status() == Status.REPEAT) {
                    classRepeat.add(clz);
                }else {
                    classSolved.add(clz);
                }
            }
        }

        System.out.println(classUnResolved);
        System.out.println(classRepeat);
        System.out.println(classSolved);
    }

}
