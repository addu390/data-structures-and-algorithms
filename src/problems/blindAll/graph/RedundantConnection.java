package problems.blindAll.graph;

import java.util.Arrays;

// https://leetcode.com/problems/redundant-connection/

// Convert cyclic graph to a tree.
// Return an edge that can be removed so that the resulting graph is a tree of n nodes.
// If there are multiple answers, return the answer that occurs last in the input.
public class RedundantConnection {
    // O(n^2) with DFS and O(n) with "Union-Find (By Rank)"
    // Note: Only one additional edge was added to the tree, resulting to a cyclic graph.

    // When there is only when cycle, number of nodes = number of edges.
    // for a tree, number of edges = number of nodes - 1

    // If two nodes have the same parent, then that results in a cycle.
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];

        int[] parents = new int[edges.length + 1];
        int[] ranks = new int[edges.length + 1];

        Arrays.fill(ranks, 1);

        for (int i = 1; i < edges.length + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i], parents, ranks)) {
                return edges[i];
            }
        }

        return result;
    }

    // Setting the right parent
    private static boolean union(int[] edge, int[] parents, int[] ranks) {
        int p1 = find(edge[0], parents);
        int p2 = find(edge[1], parents);

        if (p1 == p2) {
            return false;
        }

        if (ranks[p1] > ranks[p2]) {
            ranks[p1] = ranks[p1] + ranks[p2];
            parents[p2] = parents[p1];
        } else {
            ranks[p2] = ranks[p2] + ranks[p1];
            parents[p1] = parents[p2];
        }

        return true;
    }

    private static int find(int node, int[] parents) {
        int p = parents[node];

        // Stop when parent of itself
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }
}
