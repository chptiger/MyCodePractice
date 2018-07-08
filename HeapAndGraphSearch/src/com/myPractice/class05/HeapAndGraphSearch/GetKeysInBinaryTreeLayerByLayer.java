//Description
//        Get the list of list of keys in a given binary tree layer by layer.
//        Each layer is represented by a list of keys and the keys are traversed from left to right.
//
//        Examples
//
//        5
//
//        /    \
//
//        3        8
//
//        /   \        \
//
//        1     4        11
//
//        the result is [ [5], [3, 8], [1, 4, 11] ]
//
//        Corner Cases
//
//        What if the binary tree is null? Return an empty list of list in this case.
//        How is the binary tree represented?
//
//        We use the level order traversal sequence with a special symbol "#" denoting the null node.
//
//        For Example:
//
//        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//
//        1
//
//        /   \
//
//        2     3
//
//        /
//
//        4
package com.myPractice.class05.HeapAndGraphSearch;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here.
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> currLayer = new ArrayList<>();

            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = queue.poll();
                currLayer.add(currNode.key);
                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            list.add(currLayer);
        }
        return list;
    }
}
