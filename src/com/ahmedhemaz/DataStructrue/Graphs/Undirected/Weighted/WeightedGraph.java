package com.ahmedhemaz.DataStructrue.Graphs.Undirected.Weighted;

import java.util.*;

public class WeightedGraph<T> {
    private final HashMap<T, LinkedList<Edge<T>>> verticesMap;
    private final List<Edge<T>> edgeList;

    public WeightedGraph() {
        this.verticesMap = new HashMap<>();
        this.edgeList = new ArrayList<>();
    }

    public WeightedGraph(List<T> vertices) {
        this.verticesMap = new HashMap<>();
        this.edgeList = new ArrayList<>();
        this.initializeVerticesMap(vertices);
    }

    private void initializeVerticesMap(List<T> vertices) {
        for(T vertex: vertices) {
            this.verticesMap.put(vertex, new LinkedList<>());
        }
    }

    public void addEdge(Edge<T> edge) {
        this.edgeList.add(edge);
        T from = edge.either();
        T to = edge.other(from);
        this.verticesMap.get(from).add(edge);
        this.verticesMap.get(to).add(edge);
    }

    public void removeEdge(Edge<T> edge) {
        T from = edge.either();
        T to = edge.other(from);
        this.verticesMap.get(from).remove(edge);
        this.verticesMap.get(to).remove(edge);
    }

    public HashMap<T, LinkedList<Edge<T>>> getVerticesMap() {
        return verticesMap;
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<T, LinkedList<Edge<T>>> entry:
                this.verticesMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("->");
            for (Edge<T> t : entry.getValue()) {
                T from = t.either();
                T to = t.other(from);
                stringBuilder.append("(").
                        append(t.other(entry.getKey())).append(", ").
                        append(t.getWeight()).append(")").
                        append("->");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Character[] charactersArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        List<Character> characters = new ArrayList<>(Arrays.asList(charactersArray));
        WeightedGraph<Character> characterWeightedGraph = new WeightedGraph<>(characters);
        characterWeightedGraph.addEdge(new Edge<>('A', 'B', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('A', 'C', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('A', 'D', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('B', 'E', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('B', 'F', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('C', 'G', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('D', 'H', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('F', 'H', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('H', 'G', 1.0));
        characterWeightedGraph.addEdge(new Edge<>('H', 'E', 1.0));

        System.out.println(characterWeightedGraph.toString());
    }

}
