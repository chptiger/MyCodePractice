package com.mycodepractice.Class03;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Merge two sorted lists into one large sorted list.

        Examples

        L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
        L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
        L1 = null, L2 = null, merge L1 and L2 to null*/
public class MergeTwoSortedLinkedList {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        // link remained listNodes after curr
        if (one != null){
            curr.next = one;
        }
        if (two!= null){
            curr.next = two;
        }
        return dummy.next;
    }

    @Test
    public void test_mergeLinkedList() {
        ListNode one = null;
        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        one = merge(one, two);
        Assert.assertEquals(1, one.value);
        Assert.assertEquals(3, one.next.value);

        two = new ListNode(2);
        two.next = new ListNode(4);
        one = merge(one, two);
        Assert.assertEquals(1, one.value);
        Assert.assertEquals(2, one.next.value);
        Assert.assertEquals(3, one.next.next.value);
        Assert.assertEquals(4, one.next.next.next.value);


    }
}
