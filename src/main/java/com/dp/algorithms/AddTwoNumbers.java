package com.dp.algorithms;

import java.util.Optional;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result;

        while (l1 != null || l2 != null) {
            int val = toValue(l1) + toValue(l2) + toValue(cursor);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (val > 9) {
                cursor.val = val % 10;
                cursor.next = new ListNode(val / 10);
            } else {
                cursor.val = val;
                cursor.next = l1 != null || l2 != null ? new ListNode(0) : null;
            }
            cursor = cursor.next;
        }
        return result;
    }

    private static Integer toValue(ListNode node) {
        return Optional.ofNullable(node).map(it -> it.val).orElse(0);
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
