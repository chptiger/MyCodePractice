package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

        Examples

        L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null*/
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        return small.next;
    }

    @Test
    public void test_partition() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        head = partition(head, 3);
        Assert.assertEquals(2, head.value);
        Assert.assertEquals(1, head.next.value);
        Assert.assertEquals(4, head.next.next.value);
        Assert.assertEquals(3, head.next.next.next.value);
        Assert.assertEquals(5, head.next.next.next.next.value);

    }
}
