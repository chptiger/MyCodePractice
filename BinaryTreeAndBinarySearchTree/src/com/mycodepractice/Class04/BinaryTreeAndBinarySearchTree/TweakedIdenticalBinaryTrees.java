package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.

        Examples

        5

        /    \

        3        8

        /   \

        1      4

        and

        5

        /    \

        8        3

        /   \

        1     4

        the two binary trees are tweaked identical.

        How is the binary tree represented?

        We use the level order traversal sequence with a special symbol "#" denoting the null node.

        For Example:

        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

        1

        /   \

        2     3

        /

        4*/
public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        } else {
            return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
                    || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
        }
    }

    @Test
    public void test_isTweaked() {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(0);
        Assert.assertFalse(isTweakedIdentical(one, two));
        two.key = 5;
        Assert.assertTrue(isTweakedIdentical(one, two));
        one.left = new TreeNode(1);
        two.right = new TreeNode(1);
        Assert.assertTrue(isTweakedIdentical(one, two));
        two.right = null;
        two.left = new TreeNode(1);
        Assert.assertTrue(isTweakedIdentical(one, two));
        two.left = null;
        Assert.assertFalse(isTweakedIdentical(one, two));


    }
}
