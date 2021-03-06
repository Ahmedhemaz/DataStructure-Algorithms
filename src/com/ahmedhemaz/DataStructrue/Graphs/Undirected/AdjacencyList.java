package com.ahmedhemaz.DataStructrue.Graphs.Undirected;

import java.util.*;

public class AdjacencyList <T> {
    private final HashMap<T, LinkedList<T>> verticesMap;

    public AdjacencyList() {
        this.verticesMap = new HashMap<>();
    }

    public AdjacencyList(T[] vertices) {
        this.verticesMap = new HashMap<>();
        this.fillVerticesMap(vertices);
    }

    private void fillVerticesMap(T[] vertices) {
        for (T vertex : vertices) {
            this.verticesMap.put(vertex, new LinkedList<>());
        }
    }

    public void addEdge(T from, T to) {
        this.verticesMap.get(from).add(to);
        this.verticesMap.get(to).add(from);
    }

    public void removeEdge(T from, T to) {

        this.verticesMap.get(from).remove(to);
        this.verticesMap.get(to).remove(from);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<T, LinkedList<T>> entry:
             this.verticesMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("->");
            for (T t : entry.getValue()) {
                stringBuilder.append(t).append("->");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public HashMap<T, LinkedList<T>> getVerticesMap() {
        return verticesMap;
    }

    public static void main(String[] args) {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        AdjacencyList<Character> characterAdjacencyList = new AdjacencyList<>(characters);
        characterAdjacencyList.addEdge('A','B');
        characterAdjacencyList.addEdge('A','C');
        characterAdjacencyList.addEdge('A','D');
        characterAdjacencyList.addEdge('B','E');
        characterAdjacencyList.addEdge('B','F');
        characterAdjacencyList.addEdge('C','G');
        characterAdjacencyList.addEdge('G','C');
        characterAdjacencyList.addEdge('D','H');
        characterAdjacencyList.addEdge('F','H');
        characterAdjacencyList.addEdge('H','G');
        characterAdjacencyList.addEdge('H','E');
        System.out.println(characterAdjacencyList.toString());
        System.out.println("--------------------------------------");
        characterAdjacencyList.removeEdge('A', 'D');
        System.out.println(characterAdjacencyList.toString());
    }
}
