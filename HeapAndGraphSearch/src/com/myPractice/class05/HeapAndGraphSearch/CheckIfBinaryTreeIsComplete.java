//Description
//        Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
//
//        Examples
//
//        5
//
//        /    \
//
//        3        8
//
//        /   \
//
//        1      4
//
//        is completed.
//
//        5
//
//        /    \
//
//        3        8
//
//        /   \        \
//
//        1      4        11
//
//        is not completed.
//
//        Corner Cases
//
//        What if the binary tree is null? Return true in this case.
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

import java.util.LinkedList;
import java.util.Queue;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

// Corner case: if root is null, return true
public class CheckIfBinaryTreeIsComplete {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag =false; // flag = true means: no child nodes after this node
        queue.offer(root);

        // Case 1: curr.left is null, flag -> true
        //          if it still has right child(flag is true), return false
        // Case 2: curr.left is not null, flag is true
        //          return false;
        // Case 3: same logic for right child

        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();

            if (currNode.left == null){
                flag = true;
            }else if (flag){
                return false;
            }else{
                queue.offer(currNode.left);
            }

            if (currNode.right == null){
                flag = true;
            }else if (flag){
                return false;
            }else{
                queue.offer(currNode.right);
            }
        }
        return true;
    }
}
