package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.LinkedList;

/**
 * @author Anirudh Sharma
 * This class represents the standard implementation of a graph
 */
@SuppressWarnings("unchecked")
public class Graph {

    // Adjacency list
    public LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }
}
