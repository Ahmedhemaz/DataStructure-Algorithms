package com.ahmedhemaz.Algorithms.Graphs.CycleDetector;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;

import java.util.HashMap;
import java.util.HashSet;

public class CycleDetector<T> {
    private final AdjacencyList<T> graph;
    private final HashSet<T> visitedVertices;
    private final HashMap<T, T> parentOf;
    private boolean isCyclic;

    public CycleDetector(AdjacencyList<T> graph) {
        this.graph = graph;
        this.visitedVertices = new HashSet<>();
        this.parentOf = new HashMap<>();
        this.isCyclic = false;
    }

    public boolean isGraphCyclic(T vertex) {
        this.dfs(vertex);
        return isCyclic;
    }

    private void dfs(T vertex) {
        if (this.visitedVertices.contains(vertex)) return;
        this.visitedVertices.add(vertex);
        for (T childVertex: this.graph.getVerticesMap().get(vertex)) {
            if(this.visitedVertices.contains(childVertex)) {
                if (childVertex != this.parentOf.get(vertex)){
                    this.isCyclic = true;
                    return;
                }
            }else {
                this.parentOf.put(childVertex, vertex);
                this.dfs(childVertex);
            }
        }
    }

    public static void main(String[] args) {
        CycleDetector<Integer> cycleDetector = new CycleDetector<>(constructCyclicIntegerGraph());
        System.out.println(cycleDetector.isGraphCyclic(0));
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

    public static AdjacencyList<Integer> constructCyclicIntegerGraph() {
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
    public static AdjacencyList<Integer> constructAcyclicIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(0, 2);

        integerAdjacencyList.addEdge(1, 0);
//        integerAdjacencyList.addEdge(1, 3);

        integerAdjacencyList.addEdge(2, 0);
//        integerAdjacencyList.addEdge(2, 3);

//        integerAdjacencyList.addEdge(3, 1);
//        integerAdjacencyList.addEdge(3, 2);

        return integerAdjacencyList;
    }
}
