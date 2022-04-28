package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * Can't have loops and every node has to be connected.
 *
 * Solution: Use a hashset to keep track of visited nodes and perform DFS or BFS.
 * And also store the "previous", to different with a loop in the graph.
 * Finally number of nodes = number of visited nodes.
 * O(Edges + Nodes) - Space and Memory.
 *
 * Solution: https://www.programcreek.com/2014/05/graph-valid-tree-java/
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }

        // <Node, Adjacent nodes>
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(0, -1, map, visited)) {
            return false;
        }

        // To ensure all visited nodes = n.
        for (boolean isVisited: visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;

    }

    // False: Not valid, True: Valid.
    private boolean dfs(int currentNode, int parentNode, HashMap<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[currentNode]) {
            return false;
        }

        visited[currentNode] = true;

        for (Integer adjacentNode: map.get(currentNode)) {
            // Since parent node is
            if (adjacentNode != parentNode && !dfs(adjacentNode, currentNode, map, visited)) {
                return false;
            }
        }

        return true;
    }
}
