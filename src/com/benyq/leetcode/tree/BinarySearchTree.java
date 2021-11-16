package com.benyq.leetcode.tree;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author benyq
 * @date 2021/11/10
 * @email 1520063035@qq.com
 * 搜索二叉树
 */
public class BinarySearchTree<E> {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((e1, e2) -> e1 - e2);
        for (Integer datum : data) {
            bst.add(datum);
        }

    }

    private int size;
    private Node<E> root;
    private final Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public boolean contains(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
               return Objects.equals(element, node.element);
            }
        }
        return false;
    }

    private void remove(Node<E> node) {
        if (node == null) return;
        size--;
        if (node.left != null && node.right != null) {
            //找到前驱节点
            Node<E> s = predecessor(node);
            node.element = s.element;
            node = s;
        }
        //删除node节点
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            //node 是度为 1 的节点
            replacement.parent = node.parent;
            if (node.parent == null) { //度为1且是根节点
                root = replacement;
            }else if (node == node.parent.left) {
                node.parent.left = replacement;
            }else if (node == node.parent.right){
                node.parent.right = replacement;
            }
        }else if (node.parent == null) { //根节点
            root = null;
        }else {// 删除子节点
            if (node == node.parent.left) {
                node.parent.left = null;
            }else {
                node.parent.right = null;
            }
        }
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    private Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        //前驱节点在左子树中
        if (node.left != null) {
            Node<E> p = node;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        //前驱节点 从父节点、祖父节点中
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        //parent == null
        //node == node.parent.right
        return node.parent;
    }

    /**
     * @return 返回值等于0，相等；返回值大于0，e1大于e2；返回值小于0，e1小于e2
     */
    private int compare(E e1, E e2) {
        return comparator.compare(e1, e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

}
