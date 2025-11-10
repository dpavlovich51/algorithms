package com.dp.algorithms;


public class TreeChangingWayApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node tree = new Node(
                1,
                getLeft(),
                getRight()
        );

        printTree(tree, true);
    }

    private static Node getLeft() {
        return new Node(-3,
                new Node(-5, null, null),
                new Node(-1, null, null));
    }

    private static Node getRight() {
        return new Node(10,
                new Node(5, null, null),
                new Node(15,
                        null,
                        new Node(20, null, null))
        );
    }

    private static void printTree(Node node, boolean flag) {
        if (node == null) {
            return;
        }
        System.out.println("V: " + node.getValue());
        privatePrintTree(node, flag);
        privatePrintTree(node, !flag);
    }

    private static void privatePrintTree(Node node, boolean flag) {
        if (flag) {
            printTree(node.getLeft(), false);
        } else {
            printTree(node.getRight(), true);
        }
    }

    public static class Node {
        private final Integer value;
        private final Node left;
        private final Node right;

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