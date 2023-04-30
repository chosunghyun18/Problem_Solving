package testprac.javacoding.handleclass;

import java.util.Arrays;

public class NodeGraph {
    private  Node[] graphLine;
    public NodeGraph(Node[] graphLine){
        this.graphLine = graphLine;
    }

    public NodeGraph getExampleGraph(){
        Node[] nodes = { new Node(1, 2), new Node(1, 2), new Node(1, 2), new Node(1, 2), new Node(1, 2) };
        NodeGraph graph = new NodeGraph(nodes);
        return graph;
    }
}
