package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {

    private static boolean doesRouteExist(Graph graph, int source, int destination) {
        // Special case
        if (source == destination) {
            return true;
        }
        // Boolean array which determines if a node is visited
        // or not visited
        boolean[] visited = new boolean[graph.adjacencyList.length];
        // A queue to store BFS nodes
        Queue<Integer> nodes = new LinkedList<>();
        // Process the source node
        visited[source] = true;
        nodes.add(source);
        // Loop until queue is empty
        while (!nodes.isEmpty()) {
            // Get the first node from the queue
            int current = nodes.poll();
            // Get the adjacency list of the current node
            List<Integer> adjacencyList = graph.adjacencyList[current];
            // Loop through the adjacency list
            for (int node : adjacencyList) {
                // Check if we have found the destination
                if (node == destination) {
                    return true;
                }
                // Continue BFS
                if (!visited[node]) {
                    visited[node] = true;
                    nodes.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        int source = 1;
        int destination = 3;
        System.out.println(doesRouteExist(graph, source, destination));

        source = 3;
        destination = 1;
        System.out.println(doesRouteExist(graph, source, destination));
    }
}
