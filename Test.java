public class Test 
{
    public static void main(String[] args) 
    {
        DSAGraph graph = new DSAGraph();

        graph.addVertex(1, "Chicken");
        graph.addVertex(23, "house");
        graph.addVertex(78, "Fish");
        graph.addVertex(32, "what");
        graph.addVertex(69, "Max");
        graph.addVertex(54, "Chinchilla");

        graph.addEdge(1, 23);
        graph.addEdge(1, 78);
        graph.addEdge(78, 32);
        graph.addEdge(32, 23);
        graph.addEdge(69, 1);
        graph.addEdge(54, 78);
        graph.addEdge(54, 69);

        graph.displayAsList();
    }
}
