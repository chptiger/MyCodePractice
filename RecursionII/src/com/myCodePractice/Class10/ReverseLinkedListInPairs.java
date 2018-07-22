package com.myCodePractice.Class10;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/*Reverse pairs of elements in a singly-linked list.

        Examples

        L = null, after reverse is null
        L = 1 -> null, after reverse is 1 -> null
        L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
        L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null


        Medium
        Iterative
        Linked List
        Recursion*/


public class ReverseLinkedListInPairs {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    // method 1, recursive
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        head.next = reverseInPairs(head.next.next);
        curr.next = head;
        return curr;
    }

    // method 2, iterative
    public ListNode reverseInPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode next = curr.next.next;
            curr.next.next = curr.next.next.next;
            next.next = curr.next;
            curr.next = next;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    private String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value).append(" ");
            head = head.next;
        }
        return sb.toString();
    }

    @Test
    public void test_ReverseLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode newHead = reverseInPairs(head);
        Assert.assertEquals("2 1 ", printList(newHead));
        Assert.assertEquals("1 2 ", printList(reverseInPairs2(newHead)));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        newHead = reverseInPairs(head);
        Assert.assertEquals("2 1 3 ", printList(newHead));
        Assert.assertEquals("1 2 3 ", printList(reverseInPairs2(newHead)));

    }
}
