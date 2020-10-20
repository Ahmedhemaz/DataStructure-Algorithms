package com.ahmedhemaz.Algorithms.Graphs.BFS;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.AdjacencyList;

import java.util.*;

public class AdjacencyListBFS<T> {

    private AdjacencyList<T> graph;
    private Hashtable<T, Integer> visitedVerticesLevels;
    private Queue<T> verticesToVisit;
    private Hashtable<T, T> parent;

    public AdjacencyListBFS(AdjacencyList<T> graph) {
        this.graph = graph;
        this.visitedVerticesLevels = new Hashtable<>();
        this.verticesToVisit = new ArrayDeque<>();
        this.parent = new Hashtable<>();
        Map.Entry<T, LinkedList<T>> entry = this.graph.getVerticesMap().entrySet().stream().findFirst().get();
        verticesToVisit.add(entry.getKey());
        visitedVerticesLevels.put(entry.getKey(), 0);
    }

    public void bfs() {
        while (!verticesToVisit.isEmpty()) {
            T currentVertex = verticesToVisit.poll();
            for (T nextVertex : this.graph.getVerticesMap().get(currentVertex)) {
                if (!visitedVerticesLevels.containsKey(nextVertex)) {
                    verticesToVisit.add(nextVertex);
                    visitedVerticesLevels.put(nextVertex, visitedVerticesLevels.get(currentVertex) + 1);
                    parent.put(nextVertex, currentVertex);
                }
            }
        }
    }

    public void printVisitedVerticesLevels() {
        for (Map.Entry<T, Integer> entry :
                this.visitedVerticesLevels.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void printParentVertices() {
        for (Map.Entry<T, T> entry :
                parent.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


    public static void main(String[] args) {
        AdjacencyListBFS<Integer> adjacencyListBFS = new AdjacencyListBFS<>(constructIntegerGraph());
        adjacencyListBFS.bfs();
        adjacencyListBFS.printVisitedVerticesLevels();
        System.out.println("-------------------------------");
        adjacencyListBFS.printParentVertices();
    }

    public static AdjacencyList<Character> constructCharacterGraph() {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        AdjacencyList<Character> characterAdjacencyList = new AdjacencyList<>(characters);
        characterAdjacencyList.addEdge('A','B');
        characterAdjacencyList.addEdge('A','C');
        characterAdjacencyList.addEdge('A','D');
        characterAdjacencyList.addEdge('B','A');
        characterAdjacencyList.addEdge('B','E');
        characterAdjacencyList.addEdge('B','F');
        characterAdjacencyList.addEdge('C','A');
        characterAdjacencyList.addEdge('C','G');
        characterAdjacencyList.addEdge('G','C');
        characterAdjacencyList.addEdge('G','H');
        characterAdjacencyList.addEdge('D','A');
        characterAdjacencyList.addEdge('D','H');
        characterAdjacencyList.addEdge('E','B');
        characterAdjacencyList.addEdge('E','H');
        characterAdjacencyList.addEdge('F','B');
        characterAdjacencyList.addEdge('F','H');
        characterAdjacencyList.addEdge('H','G');
        characterAdjacencyList.addEdge('H','D');
        characterAdjacencyList.addEdge('H','E');
        characterAdjacencyList.addEdge('H','F');
        return characterAdjacencyList;
    }

    public static AdjacencyList<Integer> constructIntegerGraph() {
        Integer[] integers = {0, 1, 2, 3, 4, 5};
        AdjacencyList<Integer> integerAdjacencyList = new AdjacencyList<>(integers);
        integerAdjacencyList.addEdge(0, 2);
        integerAdjacencyList.addEdge(0, 1);
        integerAdjacencyList.addEdge(0, 5);
        integerAdjacencyList.addEdge(1, 2);
        integerAdjacencyList.addEdge(2, 3);
        integerAdjacencyList.addEdge(2, 4);
        integerAdjacencyList.addEdge(4, 3);
        integerAdjacencyList.addEdge(5, 3);
        return integerAdjacencyList;
    }
}
