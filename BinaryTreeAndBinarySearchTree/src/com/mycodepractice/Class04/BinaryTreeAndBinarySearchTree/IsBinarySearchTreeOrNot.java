package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Determine if a given binary tree is binary search tree.

        Assumptions

        There should no be duplicate keys in binary search tree.
        You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
        Corner Cases

        What if the binary tree is null? Return true in this case.*/
public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key < min || root.key > max) {
            return false;
        }
        return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
    }

    @Test
    public void test_isBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        Assert.assertTrue(isBST(root));
        root.right.left = new TreeNode(2);
        Assert.assertFalse(isBST(root));
    }
}
