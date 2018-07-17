package com.myCodePractice.Class10;

// given a binary tree,
// find the node with the max different in the total num descendents
// in its left and right subtree
public class FindNodeWithTheMaxDiffInLeftRight {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        // stores the num of node in left subtree
        int numNodesLeft;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode maxDiffNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] node = new TreeNode[1];
        int[] diff = new int[1];
        diff[0] = -1;
        numNodes(root, node, diff);
        return node[0];
    }

    // return the num of nodes in the subtree
    private int numNodes(TreeNode root, TreeNode[] node, int[] diff) {
        if (root == null) {
            return 0;
        }
        int leftNum = numNodes(root.left, node, diff);
        int rightNum = numNodes(root.right, node, diff);
        if (Math.abs(leftNum - rightNum) > diff[0]) {
            node[0] = root;
            diff[0] = Math.abs(leftNum - rightNum);
        }
        return leftNum + rightNum + 1;
    }
}
