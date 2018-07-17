package com.myCodePractice.Class10;

import jdk.nashorn.api.tree.Tree;

// Store number of nodes in left subtree
public class StoreNumberOfNodesInLeftSubtree {
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

    public void numNodesLeft(TreeNode root) {
        numNodes(root);
    }

    private int numNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // left num is the num of nodes in subtree of root.left
        int leftNum = numNodes(root.left);
        int rightNum = numNodes(root.right);
        root.numNodesLeft = leftNum;
        // return the total num of nodes in the subrree of root
        return leftNum + rightNum + 1;
    }
}
