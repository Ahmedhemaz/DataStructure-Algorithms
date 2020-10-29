package com.ahmedhemaz.Algorithms.Graphs.ConnectedComponents;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;
import java.util.*;

public class ConnectedComponents<T> {
    private final HashMap<T,Integer> verticesComponentId;
    private final HashSet<T> visitedVertices;
    private final AdjacencyList<T> graph;
    private int counter;
    public ConnectedComponents(AdjacencyList<T> graph) {
        this.graph = graph;
        this.verticesComponentId = new HashMap<>();
        this.visitedVertices = new HashSet<>();
        this.counter = 0;
        this.connect();
    }

    public void printConnectedComponents() {
        for (Map.Entry<T, Integer> entry :
                this.verticesComponentId.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private void connect() {
        for (Map.Entry<T, LinkedList<T>> vertex :
                this.graph.getVerticesMap().entrySet()) {
            if (!this.visitedVertices.contains(vertex.getKey())){
                this.dfs(vertex.getKey());
                this.counter++;
            }
        }
    }

    private void dfs(T vertex) {
        if (this.visitedVertices.contains(vertex)) return;
        this.visitedVertices.add(vertex);
        this.verticesComponentId.put(vertex, counter);
        for(T nextVertex: this.graph.getVerticesMap().get(vertex)) {
            if (!this.visitedVertices.contains(nextVertex)){
                this.dfs(nextVertex);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents<Integer> connectedComponents = new ConnectedComponents<>(constructIntegerGraph());
        connectedComponents.printConnectedComponents();
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

}
