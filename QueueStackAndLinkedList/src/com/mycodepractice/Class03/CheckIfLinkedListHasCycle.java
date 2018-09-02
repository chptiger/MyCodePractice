package com.mycodepractice.Class03;
/*Description
        Check if a given linked list has a cycle. Return true if it does, otherwise return false.*/

import org.junit.Assert;
import org.junit.Test;

public class CheckIfLinkedListHasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_cycleLinkedList() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        Assert.assertEquals(false, hasCycle(head));
        head.next.next = head;
        Assert.assertEquals(true, hasCycle(head));
    }

}
