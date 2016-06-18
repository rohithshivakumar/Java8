package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph node class.
 */
public class GraphNode<T> {

    T data;
    List<GraphNode<T>> neighbors;

    public GraphNode(T data){
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public boolean addNeighbor(GraphNode node){
        return neighbors.add(node);
    }

    public void removeNeighbor(GraphNode node){
        neighbors.remove(node);
    }
}
