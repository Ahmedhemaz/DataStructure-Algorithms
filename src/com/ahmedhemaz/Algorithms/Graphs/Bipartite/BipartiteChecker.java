package com.ahmedhemaz.Algorithms.Graphs.Bipartite;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class BipartiteChecker<T> {
    private final Queue<T> verticesToVisit;
    private final AdjacencyList<T> graph;
    private final HashMap<T, Boolean> verticesColor;
    private boolean isGraphBipartite;

    public BipartiteChecker(AdjacencyList<T> graph) {
        this.verticesToVisit = new ArrayDeque<>();
        this.verticesColor = new HashMap<>();
        this.isGraphBipartite = true;
        this.graph = graph;
    }

    public boolean isGraphBipartite(T vertex) {
        this.bfs(vertex);
        return this.isGraphBipartite;
    }

    private void bfs(T vertex) {
        this.verticesToVisit.add(vertex);
        this.verticesColor.put(vertex, false);
        while (!this.verticesToVisit.isEmpty()) {
            T currentVertex = this.verticesToVisit.poll();
            for (T childVertex :
                    this.graph.getVerticesMap().get(currentVertex)) {
                if(this.verticesColor.containsKey(childVertex)) {
                    if (this.verticesColor.get(childVertex) == this.verticesColor.get(currentVertex)) {
                        this.isGraphBipartite = false;
                        return;
                    }
                } else {
                    this.verticesToVisit.add(childVertex);
                    this.verticesColor.put(childVertex, !this.verticesColor.get(currentVertex));
                }
            }
        }
    }


    public static void main(String[] args) {
        BipartiteChecker<Integer> bipartiteChecker= new BipartiteChecker<>(constructInBipartiteIntegerGraph());
        System.out.println(bipartiteChecker.isGraphBipartite(0));
    }

    public static AdjacencyList<Integer> constructIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 6);
        integerAdjacencyList.addEdge(0, 2);
        integerAdjacencyList.addEdge(2, 0);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(1, 0);
        integerAdjacencyList.addEdge(0, 5);
        integerAdjacencyList.addEdge(5, 0);
        integerAdjacencyList.addEdge(6, 0);
        integerAdjacencyList.addEdge(6, 4);
        integerAdjacencyList.addEdge(4, 6);
        integerAdjacencyList.addEdge(4, 3);
        integerAdjacencyList.addEdge(3, 4);
        integerAdjacencyList.addEdge(4, 5);
        integerAdjacencyList.addEdge(5, 4);
        integerAdjacencyList.addEdge(3, 5);
        integerAdjacencyList.addEdge(5, 3);

        integerAdjacencyList.addEdge(7, 8);
        integerAdjacencyList.addEdge(8, 7);

        integerAdjacencyList.addEdge(9, 10);
        integerAdjacencyList.addEdge(10, 9);
        integerAdjacencyList.addEdge(9, 11);
        integerAdjacencyList.addEdge(11, 9);
        integerAdjacencyList.addEdge(9, 12);
        integerAdjacencyList.addEdge(12, 9);
        integerAdjacencyList.addEdge(11, 12);
        integerAdjacencyList.addEdge(12, 11);


        return integerAdjacencyList;
    }

    public static AdjacencyList<Integer> constructBipartiteIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(0, 2);

        integerAdjacencyList.addEdge(1, 0);
        integerAdjacencyList.addEdge(1, 3);

        integerAdjacencyList.addEdge(2, 0);
        integerAdjacencyList.addEdge(2, 3);

        integerAdjacencyList.addEdge(3, 1);
        integerAdjacencyList.addEdge(3, 2);

        return integerAdjacencyList;
    }
    public static AdjacencyList<Integer> constructInBipartiteIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(0, 2);
        integerAdjacencyList.addEdge(0, 3);


        integerAdjacencyList.addEdge(1, 0);
        integerAdjacencyList.addEdge(1, 3);

        integerAdjacencyList.addEdge(2, 0);
        integerAdjacencyList.addEdge(2, 3);

        integerAdjacencyList.addEdge(3, 1);
        integerAdjacencyList.addEdge(3, 2);
        integerAdjacencyList.addEdge(3, 0);

        return integerAdjacencyList;
    }

}
