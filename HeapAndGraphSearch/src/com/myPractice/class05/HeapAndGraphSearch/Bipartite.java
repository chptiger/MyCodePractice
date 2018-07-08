//Description
//        Determine if an undirected graph is bipartite.
//        A bipartite graph is one in which the nodes can be divided into two groups
//      such that no nodes have direct edges to other nodes in the same group.
//
//        Examples
//
//        1  --   2
//
//        /
//
//        3  --   4
//
//        is bipartite (1, 3 in group 1 and 2, 4 in group 2).
//
//        1  --   2
//
//        /   |
//
//        3  --   4
//
//        is not bipartite.
//
//        Assumptions
//
//        The graph is represented by a list of nodes, and the list of nodes is not null.


package com.myPractice.class05.HeapAndGraphSearch;

import java.util.*;

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here

        // The map maintains for each node which group it belongs to.
        // use 0 and 1  to denote 2 different groups.
        HashMap<GraphNode, Integer> visited = new HashMap<>();

        for (GraphNode node : graph){
            if (!BFS(node, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode,Integer> visited) {
        // no need to do BFS if curr node has been visited
        if (visited.containsKey(node)){
            return true;
        }

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);
        // since this node has not been visited, it can be assigned any group num, says 0
        visited.put(node, 0);

        while (!queue.isEmpty()){
            GraphNode currNode = queue.poll();
            int currGroup = visited.get(currNode);
            int neibGroup = currGroup == 0? 1: 0;

            for (GraphNode neibNode : currNode.neighbors){
                if (!visited.containsKey(neibNode)){
                    visited.put(neibNode, neibGroup);
                }else if (visited.get(neibNode) != neibGroup){
                    return false;
                }
            }

        }
        return true;
    }

}
