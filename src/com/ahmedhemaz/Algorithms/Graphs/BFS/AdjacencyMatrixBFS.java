package com.ahmedhemaz.Algorithms.Graphs.BFS;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyMatrix;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;

public class AdjacencyMatrixBFS<T> {
    private AdjacencyMatrix<T> graph;
    private Queue<T> verticesToVisit;
    private Hashtable<T, Integer> verticesLevels;
    private Hashtable<T,T> parentOf;

    public AdjacencyMatrixBFS(AdjacencyMatrix<T> graph) {
        this.graph = graph;
        this.verticesToVisit = new ArrayDeque<>();
        this.verticesLevels = new Hashtable<>();
        this.parentOf = new Hashtable<>();
    }

    public void bfs(T from) {
        this.verticesToVisit.add(from);
        this.verticesLevels.put(from, 0);
        while (!this.verticesToVisit.isEmpty()) {
            T currentVertex = this.verticesToVisit.poll();
            int indexOfCurrentVertex = this.graph.indexOf(currentVertex);
            boolean[][] matrix = this.graph.getAdjacencyMatrix();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[indexOfCurrentVertex][i]) {
                    if (!this.verticesLevels.containsKey(this.graph.getVertexOfIndex(i))) {
                        this.verticesToVisit.add(this.graph.getVertexOfIndex(i));
                        this.verticesLevels.put(this.graph.getVertexOfIndex(i), this.verticesLevels.get(currentVertex) + 1);
                        this.parentOf.put(this.graph.getVertexOfIndex(i), this.graph.getVertexOfIndex(indexOfCurrentVertex));
                    }
                }
            }
        }
    }

    public void printVisitedVerticesLevels() {
        for (Map.Entry<T, Integer> entry :
                this.verticesLevels.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void printParentVertices() {
        for (Map.Entry<T, T> entry :
                this.parentOf.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixBFS<Integer> integerAdjacencyMatrixBFS = new AdjacencyMatrixBFS<>(constructIntegerAdjacencyMatrix());
        integerAdjacencyMatrixBFS.bfs(0);
        integerAdjacencyMatrixBFS.printParentVertices();
        System.out.println("-------------------------------------------");
        integerAdjacencyMatrixBFS.printVisitedVerticesLevels();
    }

    public static AdjacencyMatrix<Integer> constructIntegerAdjacencyMatrix() {
        Integer[] vertices = {0,1,2,3};
        AdjacencyMatrix<Integer> integerAdjacencyMatrix = new AdjacencyMatrix<>(vertices.length,vertices);
        integerAdjacencyMatrix.addEdge(0,1);
        integerAdjacencyMatrix.addEdge(0,2);
        integerAdjacencyMatrix.addEdge(1,3);
        return integerAdjacencyMatrix;
    }
}
