package org.ua.javaPro.berezhnoy.simpleTreeStructure;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SimpleTree {
    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void traverse() {
        List<Integer> traversal = new ArrayList<>();
        inOrderTraversal(root, traversal);
        for (int value : traversal) {
            System.out.print(value + " ");
        }
    }

    private void inOrderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            inOrderTraversal(node.left, traversal);
            traversal.add(node.value);
            inOrderTraversal(node.right, traversal);
        }
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
