package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Reverse a singly-linked list.

        Examples

        L = null, return null
        L = 1 -> null, return 1 -> null
        L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null*/
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    @Test
    public void test_reverseLL() {
        ListNode head = null;
        Assert.assertEquals(null, reverse(head));
        head = new ListNode(1);
        head = reverse(head);
        Assert.assertEquals(1, head.value);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = reverse(head);
        Assert.assertEquals(3, head.value);
        Assert.assertEquals(2, head.next.value);
        Assert.assertEquals(1, head.next.next.value);
        Assert.assertNull(head.next.next.next);
    }
}
