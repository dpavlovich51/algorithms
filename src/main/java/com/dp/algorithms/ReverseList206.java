package com.dp.algorithms;

import java.util.concurrent.atomic.AtomicReference;

public class ReverseList206 {

    public static void main(String[] args) {
        ListNode node = reverseList(new ListNode(1, new ListNode(2, new ListNode(3))));
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        AtomicReference<ListNode> ptr = new AtomicReference<>(head);
        ListNode node = reverseList(ptr, head);
        node.next = null;
        return ptr.get();
    }

    private static ListNode reverseList(AtomicReference<ListNode> ptr, ListNode next) {
        if (next.next != null) {
            ListNode result = reverseList(ptr, next.next);
            result.next = next;
            return next;
        }
        ptr.set(new ListNode(next.val));
        return ptr.get();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
