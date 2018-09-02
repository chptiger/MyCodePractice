package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/*Description
        Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        Pre-order traversal is [5, 3, 1, 4, 8, 11]

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
public class PreorderTraversal {
    // method 1, recursive
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        result.add(root.key);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // method 2, iterative
    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        stack.offerFirst(curr);
        while (!stack.isEmpty()){
            curr = stack.pollFirst();
            if (curr.right != null){
                stack.offerFirst(curr.right);
            }
            if (curr.left != null){
                stack.offerFirst(curr.left);
            }
            result.add(curr.key);
        }
        return result;
    }

    @Test
    public void test_preOrder() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(5, 3, 1, 4, 8, 11)), preOrder(root));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(5, 3, 1, 4, 8, 11)), preOrder2(root));
    }
}
