public class DSAGraph 
{
    // Class fields
    private DSALinkedList vertices;
    private int edgeCount = 0;

    // Constructor
    public DSAGraph()
    {
        vertices = new DSALinkedList();
    }

    // Mutator
    public void addVertex(int label, Object value)
    {
        DSAGraphVertex newVertex = new DSAGraphVertex(label, value);

        vertices.insertLast(newVertex);
    }
    // Mutator
    public void addEdge(int label1, int label2)
    {
        DSAGraphVertex vertex1 = vertices.findVertex(label1);
        DSAGraphVertex vertex2 = vertices.findVertex(label2);

        // Add 2 vertices in both directions as it is an undirected graph.
        vertex1.addEdge(vertex2);
        vertex2.addEdge(vertex1);

        edgeCount++;
    }
    // Accessor
    public boolean hasVertex(int label)
    {
        DSAGraphVertex vertexExistence = vertices.findVertex(label);
        boolean hasVertex = true;

        if(vertexExistence == null)
        {
            hasVertex = false;
        }

        return hasVertex;
    }
    // Accessor
    public int getVertexCount()
    {
        return vertices.count();
    }
    // Accessor
    public int getEdgeCount()
    {   
        return edgeCount;
    }

    // Accessor
    public DSAGraphVertex getVertex(int label)
    {
        DSAGraphVertex retrievedVertex = vertices.findVertex(label);

        return retrievedVertex;
    }
    // Accessor
    public DSALinkedList getAdjacent(int label)
    {
        DSAGraphVertex vertex = vertices.findVertex(label);

        return vertex.getAdjacent();  // Returning the links list of a given vertex.
    }
    // Accessor
    public boolean isAdjacent(int label1, int label2)
    {
        boolean isAdjacent = false;

        DSAGraphVertex vertex1 = vertices.findVertex(label1);
        DSAGraphVertex vertex2 = vertices.findVertex(label2);

        // Check if vertex 2 is adjacent to vertex 1. (Vertex 2 is in vertex 1's links list)
        boolean vertex2Adjacent = false;
        for(int i = 0; i < vertex1.getAdjacent().count(); i++)
        {
            // Check if vertex 2 exists in vertex 1's links list (cannot be null)
            if(vertex1.getAdjacent().findVertex(label2) != null)
            {
                vertex2Adjacent = true;
            }
        }
        
        // Check if vertex 1 is adjacent to vertex 2. (Vertex 1 is in vertex 2's links list)
        boolean vertex1Adjacent = false;
        for(int i = 0; i < vertex2.getAdjacent().count(); i++)
        {
            // Check if vertex 1 exists in vertex 2's links list (cannot be null)
            if(vertex2.getAdjacent().findVertex(label1) != null)
            {
                vertex1Adjacent = true;
            }
        }

        if((vertex1Adjacent == true) && (vertex2Adjacent == true))
        {
            isAdjacent = true;
        }

        return isAdjacent;
    }

    // Function to print the graph
    public void printGraph()
    {
        vertices.printLinkedList();
        System.out.println();
    }
}
