public class DSAGraph 
{
    // Class fields
    private DSALinkedList vertices;

    // Constructor
    public DSAGraph()
    {
        vertices = new DSALinkedList();
    }

    // Mutator
    public void addVertex(int label, Object value)
    {
        DSAGraphVertex vertex = new DSAGraphVertex(label, value);

        vertices.insertLast(vertex);
    }
    // Mutator
    public void addEdge(int label1, int label2)
    {
        DSAGraphVertex vertex1 = vertices.findVertex(label1);
        DSAGraphVertex vertex2 = vertices.findVertex(label2);
    }

    // Function to print the graph
    public void printGraph()
    {
        vertices.printLinkedList();
        System.out.println();
    }
}
