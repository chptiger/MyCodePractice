package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

/*Description
        Check if a given binary tree is balanced.
        A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        is balanced binary tree,

        5

        /

        3

        /   \

        1      4

        is not balanced binary tree.

        Corner Cases

        What if the binary tree is null? Return true in this case.
        How is the binary tree represented?

        We use the level order traversal sequence with a special symbol "#" denoting the null node.

        For Example:

        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

        1

        /   \

        2     3

        /

        4*/
public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (getHeight(root) == -1){
            return false;
        }else{
            return true;
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    public void test_isBalanced(){
        TreeNode root = null;
        Assert.assertTrue(isBalanced(root));
        root = new TreeNode(1);
        Assert.assertTrue(isBalanced(root));
        root.left = new TreeNode(1);
        Assert.assertTrue(isBalanced(root));
        root.right = new TreeNode(1);
        Assert.assertTrue(isBalanced(root));
        root.left.left=new TreeNode(1);
        Assert.assertTrue(isBalanced(root));
        root.left.left.right = new TreeNode(1);
        Assert.assertFalse(isBalanced(root));
    }

}
