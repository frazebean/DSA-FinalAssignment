public class Test 
{
    public static void main(String[] args) 
    {
        DSAGraph graph = new DSAGraph();

        graph.addVertex(1, "House");
        graph.addVertex(2, "Every");
        graph.addVertex(3, "Weekend");
        graph.addVertex(4, "House Every Weekend");
        graph.addVertex(5, "House house house house");

        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(1, 5);

        // NOTE: Always remove edges first. Then remove vertex.

        graph.removeVertex(3);

        graph.displayAsList();
    }
}
