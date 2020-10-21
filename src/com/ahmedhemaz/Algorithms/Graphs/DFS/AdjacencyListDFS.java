package com.ahmedhemaz.Algorithms.Graphs.DFS;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class AdjacencyListDFS<T> {
    private final AdjacencyList<T> graph;
    private final Hashtable<T,T> parentOfVertex;
    private final HashSet<T> visitedVertices;

    public AdjacencyListDFS(AdjacencyList<T> graph) {
        this.graph = graph;
        this.parentOfVertex = new Hashtable<>();
        this.visitedVertices = new HashSet<>();
    }

    public void dfs(T vertex) {
        if (this.visitedVertices.contains(vertex)) return;
        this.visitedVertices.add(vertex);
        for (T nextVertex : this.graph.getVerticesMap().get(vertex)) {
            if (!this.visitedVertices.contains(nextVertex)) {
                this.parentOfVertex.put(nextVertex, vertex);
            }
            this.dfs(nextVertex);
        }
    }

    public boolean dfs(T from, T to) {
        if (this.visitedVertices.contains(from)) return false;
        if (from.equals(to)) return true;
        this.visitedVertices.add(from);
        for (T child :
                this.graph.getVerticesMap().get(from)) {
            if (this.dfs(child,to)){
                return true;
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
        AdjacencyListDFS<Integer> integerAdjacencyListDFS = new AdjacencyListDFS<>(constructIntegerGraph());
        integerAdjacencyListDFS.dfs(0);
        integerAdjacencyListDFS.printParentVertices();
//        System.out.println(integerAdjacencyListDFS.dfs(0,5));
    }


    public static AdjacencyList<Integer> constructIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6};
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

        return integerAdjacencyList;
    }}
