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
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode ll = lowestCommonAncestor(root.left, one, two);
        TreeNode lr = lowestCommonAncestor(root.right, one, two);
        if (ll != null && lr != null) {
            return root;
        }
        return ll == null ? lr : ll;
    }

    @Test
    public void test_LCA() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(14);
        Assert.assertEquals(5, lowestCommonAncestor(root, root.left.left, root.right.right).key);
        Assert.assertEquals(9, lowestCommonAncestor(root, root.left.left, root.left).key);
    }
}
