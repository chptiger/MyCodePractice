package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/*Description
        Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        In-order traversal is [1, 3, 4, 5, 8, 11]

        Corner Cases

        What if the given binary tree is null? Return an empty list in this case.
        How is the binary tree represented?

        We use the level order traversal sequence with a special symbol "#" denoting the null node.

        For Example:

        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

        1

        /   \

        2     3

        /

        4*/
public class InorderTraversal {
    // method 1, recursion
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.key);
        inOrder(root.right, result);
    }

    // method 2, iterative
    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }else{
                curr = stack.pollFirst();
                result.add(curr.key);
                curr = curr.right;
            }
        }
        return result;
    }

    @Test
    public void test_inOrder() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 3, 4, 5, 8, 11)), inOrder(root));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 3, 4, 5, 8, 11)), inOrder2(root));
    }
}
