package com.ahmedhemaz.DataStructrue.Graphs.directed.Weighted;

public class DirectedEdge<T> implements Comparable<DirectedEdge<T>> {

    private final T from;
    private final T to;
    private final Double weight;

    public DirectedEdge(T from, T to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public T getFrom() {
        return  this.from;
    }

    public T getTo() {
        return to;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge<T> thatDirectedEdge) {
        if(this.weight > thatDirectedEdge.weight) return 1;
        else if (this.weight < thatDirectedEdge.weight) return -1;
        else return 0;
    }
}
