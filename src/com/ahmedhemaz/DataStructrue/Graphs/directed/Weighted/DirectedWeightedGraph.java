package com.ahmedhemaz.DataStructrue.Graphs.directed.Weighted;

import com.ahmedhemaz.DataStructrue.Graphs.Undirected.Weighted.Edge;
import com.ahmedhemaz.DataStructrue.Graphs.Undirected.Weighted.WeightedGraph;

import java.util.*;

public class DirectedWeightedGraph<T> {

    private final HashMap<T, LinkedList<DirectedEdge<T>>> verticesMap;
    private final List<DirectedEdge<T>> directedEdgeList;

    public DirectedWeightedGraph() {
        this.verticesMap = new HashMap<>();
        this.directedEdgeList = new ArrayList<>();
    }

    public DirectedWeightedGraph(List<T> vertices) {
        this.verticesMap = new HashMap<>();
        this.directedEdgeList = new ArrayList<>();
        this.initializeVerticesMap(vertices);
    }

    private void initializeVerticesMap(List<T> vertices) {
        for (T vertex: vertices) {
            this.verticesMap.put(vertex, new LinkedList<>());
        }
    }

    public void addEdge(DirectedEdge<T> directedEdge) {
        this.directedEdgeList.add(directedEdge);
        T from = directedEdge.getFrom();
        this.verticesMap.get(from).add(directedEdge);
    }

    public void removeEdge(DirectedEdge<T> directedEdge) {
        this.directedEdgeList.remove(directedEdge);
        T from = directedEdge.getFrom();
        this.verticesMap.get(from).remove(directedEdge);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<T, LinkedList<DirectedEdge<T>>> entry:
                this.verticesMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("->");
            for (DirectedEdge<T> t : entry.getValue()) {
                stringBuilder.append("(").
                        append(t.getTo()).append(", ").
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
        DirectedWeightedGraph<Character> characterWeightedGraph = new DirectedWeightedGraph<>(characters);
        characterWeightedGraph.addEdge(new DirectedEdge<>('A', 'B', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('A', 'C', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('A', 'D', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('B', 'E', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('B', 'F', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('C', 'G', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('D', 'H', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('F', 'H', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('H', 'G', 1.0));
        characterWeightedGraph.addEdge(new DirectedEdge<>('H', 'E', 1.0));

        System.out.println(characterWeightedGraph.toString());
    }
}
