package com.myCodePractice.Class10;

/*Description
        Given two nodes in a binary tree, find their lowest common ancestor.
        Assumptions
        There is no parent pointer for the nodes in the binary tree
        The given two nodes are guaranteed to be in the binary tree
        Examples
        5
        /   \
        9     12
        /  \      \
        2    3      14

        The lowest common ancestor of 2 and 14 is 5
        The lowest common ancestor of 2 and 9 is 9
        Medium
        Binary Tree
*/
import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorI {

    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here.
        return root;
    }

    @Test
    public void test_LCA(){
        //Assert.assertEquals("", lowestCommonAncestor());
    }
}
