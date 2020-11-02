package com.ahmedhemaz.Algorithms.Graphs.TopologicalSort;

import com.ahmedhemaz.DataStructrue.Graphs.directed.DirectedAdjacencyList;

import java.util.HashSet;
import java.util.Stack;

public class TopologicalSortIterative<T> {
    private DirectedAdjacencyList<T> graph;
    private HashSet<T> visitedVertices;
    private Stack<T> verticesToVisit;
    private Stack<T> topologicalStack;

    public TopologicalSortIterative(DirectedAdjacencyList<T> graph) {
        this.graph = graph;
//        if (this.isGraphCyclic()) throw new IllegalArgumentException("Cyclic Graph Found");
        this.visitedVertices = new HashSet<>();
        this.verticesToVisit = new Stack<>();
        this.topologicalStack = new Stack<>();

    }

//    private boolean isGraphCyclic() {
//        return new CycleDetector<T>(this.graph).isGraphCyclic(
//                this.graph.getVerticesMap().entrySet().stream().findFirst().get().getKey()
//        );
//    }


    public void sort() {
        for (T vertex :
                this.graph.getVerticesMap().keySet()) {
            if(!this.visitedVertices.contains(vertex)) {
                this.dfs(vertex);
            }
        }
    }

    private void dfs(T vertex) {
        this.verticesToVisit.add(vertex);
        Stack<T> tempStack = new Stack<>();
        while (!this.verticesToVisit.isEmpty()) {
            T currentVertex = this.verticesToVisit.pop();
            this.visitedVertices.add(currentVertex);
            for (T childVertex :
                    this.graph.getVerticesMap().get(currentVertex)) {
                if (!this.visitedVertices.contains(childVertex)) {
                    this.verticesToVisit.add(childVertex);
                    tempStack.add(childVertex);
                }
            }
        }
        while (!tempStack.isEmpty()){
            this.topologicalStack.add(tempStack.pop());
        }
        this.topologicalStack.add(vertex);
    }

    public Stack<T> getTopologicalStack() {
        return this.topologicalStack;
    }


    public static void main(String[] args) {
        TopologicalSortIterative<Integer> integerTopologicalSort = new TopologicalSortIterative<>(constructAlgorithmsPartTwoDAG());
        integerTopologicalSort.sort();
        for (Integer vertex :
                integerTopologicalSort.getTopologicalStack()) {
                System.out.println(vertex);
        }
    }

    public static DirectedAdjacencyList<Integer> constructAlgorithmsPartTwoDAG() {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6};
        DirectedAdjacencyList<Integer> integerDirectedAdjacencyList = new DirectedAdjacencyList<>(integers);
        integerDirectedAdjacencyList.addEdge(0,5);
        integerDirectedAdjacencyList.addEdge(0,2);
        integerDirectedAdjacencyList.addEdge(0,1);
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
