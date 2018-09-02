package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/*Description
        Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        Post-order traversal is [1, 4, 3, 11, 8, 5]

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
public class PostorderTraversal {
    // method 1, recursive
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        postOrder(root.left,result);
        postOrder(root.right, result);
        result.add(root.key);
    }

    // method 2, iterative
    public List<Integer> postOrder2(TreeNode root) {
        // postOrder is left, right, root
        // so we make it as root, right, left, like preOrder, and reverse at the end
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        stack.offerFirst(curr);
        while (!stack.isEmpty()){
            curr = stack.pollFirst();
            result.add(curr.key);
            if (curr.left != null){
                stack.offerFirst(curr.left);
            }
            if (curr.right != null){
                stack.offerFirst(curr.right);
            }
        }
        Collections.reverse(result);
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
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 4, 3, 11, 8, 5)), postOrder(root));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 4, 3, 11, 8, 5)), postOrder2(root));
    }
}
