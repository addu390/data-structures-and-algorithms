package problems.leetcode.graph;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return node;
        }
        // Hashmap - Like any other graph problem, maps old to new node.
        // Breath First Search (BFS) - Queue
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node head = new Node(node.val, new ArrayList<>());
        oldToNew.put(node, head);
        queue.add(node);

        /*
         * The breadth first search continues until we have processed all vertices in
         * the original graph. We know this is done when the queue is empty
         */
        while (!queue.isEmpty()) {
            Node temp = queue.remove();

            // Iterate over all adjacents/neighbors
            for (Node n: temp.neighbors) {
                if (!oldToNew.containsKey(n)) {
                    oldToNew.put(n, new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }
                oldToNew.get(temp).neighbors.add(oldToNew.get(n));
            }
        }
        return head;
    }
}
