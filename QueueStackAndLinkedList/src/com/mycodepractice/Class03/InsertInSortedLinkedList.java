package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Insert a value in a sorted linked list.

        Examples

        L = null, insert 1, return 1 -> null
        L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
        L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
        L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null*/
public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // add value before head
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        // add value after head
        ListNode prev = head;
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    @Test
    public void test_insertLinkedList() {
        ListNode head = new ListNode(1);
        head = insert(head, 0);
        Assert.assertEquals(0, head.value); // 1->Null to 0->1->Null
        head = insert(head, 3);
        Assert.assertEquals(3, head.next.next.value); // 0->1->Null to 0->1->3->Null
        head = insert(head, 2);
        Assert.assertEquals(2, head.next.next.value); // 0->1->3->Null to 0->1->2->3->Null
    }
}
