package com.mycodepractice.Class04.BinaryTreeAndBinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Description
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4*/
public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getRange(root, min, max, result);
        return result;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.key > min) { // find left bound
            getRange(root.left, min, max, result);
        }
        if (root.key >= min && root.key<=max) {
            result.add(root.key);
        }
        if (root.key < max) { // find right bound
            getRange(root.right, min, max, result);
        }
    }

    @Test
    public void test_rangeInTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(3, 5)), getRange(root, 2, 5));
        root.left.left = new TreeNode(1);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(3, 5)), getRange(root, 2, 5));
        root.left.right = new TreeNode(4);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(3, 4, 5)), getRange(root, 2, 5));
        root.right.right = new TreeNode(11);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(3, 4, 5)), getRange(root, 2, 5));
    }
}
