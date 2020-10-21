package com.ahmedhemaz.Algorithms.Graphs.DFS;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class AdjacencyListDFSIterative<T> {
    private final AdjacencyList<T> graph;
    private final Hashtable<T,T> parentOfVertex;
    private final HashSet<T> visitedVertices;
    private final Stack<T> nextVerticesToVisit;

    public AdjacencyListDFSIterative(AdjacencyList<T> graph) {
        this.graph = graph;
        this.parentOfVertex = new Hashtable<>();
        this.visitedVertices = new HashSet<>();
        this.nextVerticesToVisit = new Stack<>();
    }

    public void dfs(T vertex) {
        this.nextVerticesToVisit.add(vertex);
        while (!this.nextVerticesToVisit.isEmpty()) {
            T currentVertex = this.nextVerticesToVisit.pop();
            this.visitedVertices.add(currentVertex);
            for (T child :
                    this.graph.getVerticesMap().get(currentVertex)) {
                if (!this.visitedVertices.contains(child)) {
                    this.nextVerticesToVisit.add(child);
                    this.parentOfVertex.put(child, currentVertex);
                }
            }
        }
    }

    public boolean dfs(T from, T to) {
        this.nextVerticesToVisit.add(from);
        while (!this.nextVerticesToVisit.isEmpty()) {
            T currentVertex = this.nextVerticesToVisit.pop();
            if (currentVertex == to) return true;
            this.visitedVertices.add(currentVertex);
            for (T child :
                    this.graph.getVerticesMap().get(currentVertex)) {
                if (!this.visitedVertices.contains(child)) {
                    this.nextVerticesToVisit.add(child);
                    this.parentOfVertex.put(child, currentVertex);
                }
            }
        }
        return false;
    }

    public void printParentVertices() {
        for (Map.Entry<T, T> entry :
                this.parentOfVertex.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        AdjacencyListDFSIterative<Integer> integerAdjacencyListDFSIterative = new AdjacencyListDFSIterative<>(constructIntegerGraph());
        integerAdjacencyListDFSIterative.dfs(0);
        integerAdjacencyListDFSIterative.printParentVertices();
    }


    public static AdjacencyList<Integer> constructIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(0, 2);
        integerAdjacencyList.addEdge(0, 5);
        integerAdjacencyList.addEdge(0, 6);
        integerAdjacencyList.addEdge(2, 0);
        integerAdjacencyList.addEdge(1, 0);
        integerAdjacencyList.addEdge(5, 0);
        integerAdjacencyList.addEdge(5, 3);
        integerAdjacencyList.addEdge(5, 4);
        integerAdjacencyList.addEdge(3, 5);
        integerAdjacencyList.addEdge(6, 4);
        integerAdjacencyList.addEdge(6, 0);
        integerAdjacencyList.addEdge(4, 6);
        integerAdjacencyList.addEdge(4, 5);
        integerAdjacencyList.addEdge(4, 3);
        integerAdjacencyList.addEdge(3, 4);

        return integerAdjacencyList;
    }
}
