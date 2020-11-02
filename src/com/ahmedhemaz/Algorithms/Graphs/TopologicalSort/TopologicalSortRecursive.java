package com.ahmedhemaz.Algorithms.Graphs.TopologicalSort;

import com.ahmedhemaz.DataStructrue.Graphs.directed.DirectedAdjacencyList;

import java.util.HashSet;
import java.util.Stack;

public class TopologicalSortRecursive<T> {
    private DirectedAdjacencyList<T> graph;
    private HashSet<T> visitedVertices;
    private Stack<T> topologicalStack;

    public TopologicalSortRecursive(DirectedAdjacencyList<T> graph) {
        this.graph = graph;
        this.visitedVertices = new HashSet<>();
        this.topologicalStack = new Stack<>();
    }

    private void sort() {
        for (T vertex :
                this.graph.getVerticesMap().keySet()) {
            if(!this.visitedVertices.contains(vertex)) {
                this.dfs(vertex);
            }
        }
    }

    private void dfs(T vertex) {
        if (this.visitedVertices.contains(vertex)) return;
        this.visitedVertices.add(vertex);
        for (T childVertex :
                this.graph.getVerticesMap().get(vertex)) {
            if (!this.visitedVertices.contains(childVertex)) {
                this.dfs(childVertex);
            }
        }
        this.topologicalStack.add(vertex);
    }
    public Stack<T> getTopologicalStack() {
        return this.topologicalStack;
    }

    public static void main(String[] args) {
        TopologicalSortRecursive<Integer> integerTopologicalSort = new TopologicalSortRecursive<>(constructAlgorithmsPartTwoDAG());
        integerTopologicalSort.sort();
        for (Integer vertex :
                integerTopologicalSort.getTopologicalStack()) {
            System.out.println(vertex);
        }
    }

    public static DirectedAdjacencyList<Integer> constructAlgorithmsPartTwoDAG() {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6};
        DirectedAdjacencyList<Integer> integerDirectedAdjacencyList = new DirectedAdjacencyList<>(integers);
        integerDirectedAdjacencyList.addEdge(0,1);
        integerDirectedAdjacencyList.addEdge(0,5);
        integerDirectedAdjacencyList.addEdge(0,2);
        integerDirectedAdjacencyList.addEdge(3,6);
        integerDirectedAdjacencyList.addEdge(3,5);
        integerDirectedAdjacencyList.addEdge(3,4);
        integerDirectedAdjacencyList.addEdge(3,2);
        integerDirectedAdjacencyList.addEdge(5,2);
        integerDirectedAdjacencyList.addEdge(6,4);
        integerDirectedAdjacencyList.addEdge(6,0);
        integerDirectedAdjacencyList.addEdge(1,4);
        return integerDirectedAdjacencyList;
    }
}
