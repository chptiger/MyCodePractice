package com.mycodepractice.Class03;
/*Description
        Find the middle node of a given linked list.

        Examples

        L = null, return null
        L = 1 -> null, return 1
        L = 1 -> 2 -> null, return 1
        L = 1 -> 2 -> 3 -> null, return 2
        L = 1 -> 2 -> 3 -> 4 -> null, return 2*/

import org.junit.Assert;
import org.junit.Test;

public class FindMiddleNodeOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    @Test
    public void test_findMiddle(){
        ListNode head = new ListNode(0);
        Assert.assertEquals(0, middleNode(head).value);
        head.next = new ListNode(1);
        Assert.assertEquals(0, middleNode(head).value);
        head.next.next = new ListNode(2);
        Assert.assertEquals(1, middleNode(head).value);
    }
}
