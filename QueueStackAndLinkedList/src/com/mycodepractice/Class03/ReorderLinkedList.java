package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

        Examples

        L = null, is reordered to null
        L = 1 -> null, is reordered to 1 -> null
        L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
        L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null*/
public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. find mid
        ListNode mid = findMiddle(head);
        // 2. partition into 2 linked list
        ListNode one = head;
        ListNode two = mid.next;
        mid.next = null;
        // 3. reverse 2nd one
        two = reverse(two);
        // 4. merge together
        head = merge(one, two);
        return head; // return merge(one, reverse(two))
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (one != null && two != null) {
            curr.next = one;
            one = one.next;
            curr.next.next = two;
            two = two.next;
            curr = curr.next.next;
        }
        if (one != null) {
            curr.next = one;
        } else {
            curr.next = two;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void test_reorder() {
        ListNode head = reorder(null);
        Assert.assertEquals(null, head);
        head = new ListNode(1);
        head = reorder(head);
        Assert.assertEquals(1, head.value);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = reorder(head);
        Assert.assertEquals(1, head.value);
        Assert.assertEquals(3, head.next.value);
        Assert.assertEquals(2, head.next.next.value);
        head.next.next.next = new ListNode(4);
        head = reorder(head);
        Assert.assertEquals(1, head.value);
        Assert.assertEquals(4, head.next.value);
        Assert.assertEquals(3, head.next.next.value);
        Assert.assertEquals(2, head.next.next.next.value);
        Assert.assertNull(head.next.next.next.next);

    }
}
