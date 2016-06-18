package Graphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/18/2016.
 */
public class GraphTest {

    @Test
    public void testGetNode() throws Exception {
        //Create directed graph
        Graph<String> graph = new Graph<>("0,1,2#1,2#2,2", false);
        graph.printGraph();

        assertNotNull("Node with value '0' not found ",graph.getNode("0"));
        assertNull("Node with value '10' not found ",graph.getNode("10"));
    }

    @Test
    public void testGraph() throws Exception {

        //Create directed graph
        Graph<String> graph = new Graph<>("0,1,2#1,2#2,2", false);
        graph.printGraph();

        //Create undirectedGraph
        graph = new Graph<>("0,1,2#1,2#2,2", true);
        graph.printGraph();
    }
}