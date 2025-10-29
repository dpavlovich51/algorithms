package com.dp.algorithms;


public class TreeApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node tree = new Node(
                1,
                new Node(-1, null, null),
                new Node(10,
                        new Node(5, null, null),
                        new Node(15, null
                                , new Node(
                                20, null, null
                        ))
                )
        );

        printTree(tree);
    }

    public static void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeft());
        System.out.println(node.getValue());
        printTree(node.getRight());
    }

    public static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.right = right;
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Integer getValue() {
            return value;
        }
    }
}