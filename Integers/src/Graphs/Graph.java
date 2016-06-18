package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Graph Class represented by an adjacency list
 */
public class Graph<T> {

    List<GraphNode<T>> nodes ;
    boolean undirectedGraph;

    public GraphNode getNode(T value){
        for(GraphNode g : nodes){
            if(g.data.equals(value)){
                return g;
            }
        }
        return  null;
    }

    public void printGraph() {
        for(GraphNode node : nodes){
            System.out.print(node.data + "->");
            for(Object neighbor : node.neighbors){
                System.out.print(((GraphNode<String>)neighbor).data + ":");
            }
            System.out.println();
        }

    }

    /*
   We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
   As an example, consider the serialized graph {0,1,2#1,2#2,2}.
   The graph has a total of three nodes, and therefore contains three parts as separated by #.
       1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
       2. Second node is labeled as 1. Connect node 1 to node 2.
       3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
   Visually, the graph looks like the following:
          1
         / \
        /   \
       0 --- 2
            / \
            \_/
    */
    public Graph(String g, boolean undirected){
        undirectedGraph = undirected;

        String[] parts = g.split("#");
        nodes = new ArrayList<>();
        for(String s: parts){
            String[] nodeString = s.split(",");
            if(nodeString.length == 0){
                throw new IllegalArgumentException("Invalid input");
            }
            String nodeVal = nodeString[0];
            GraphNode node = getNode((T)nodeVal);
            if(node== null){
                node = new GraphNode(nodeVal);
                nodes.add(node);
            }
            for(int i=1; i<nodeString.length; i++){
                GraphNode neighbor = getNode((T)nodeString[i]);
                if(neighbor== null){
                    neighbor = new GraphNode((T)nodeString[i]);
                    nodes.add(neighbor);
                }
                node.neighbors.add(neighbor);
                if(undirectedGraph){
                    neighbor.neighbors.add(node);
                }
            }

        }
    }
}
