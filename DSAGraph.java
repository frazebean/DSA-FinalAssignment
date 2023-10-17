public class DSAGraph 
{
    // Class fields
    private DSALinkedList vertices;
    private int edgeCount = 0;
    private int vertexCount = 0;

    // Constructor
    public DSAGraph()
    {
        vertices = new DSALinkedList();
    }

    // Mutator
    public void addVertex(int label, Shop value)
    {
        DSAGraphVertex newVertex = new DSAGraphVertex(label, value);
        vertices.insertLast(newVertex);
        vertexCount++;
    }
    // Mutator
    public void removeVertex(int label)
    {
        DSAGraphVertex vertexToRemove = vertices.findVertex(label);

        // Before removing the actual vertex, any edges connected to the vertex should also
        // be removed.

        // We first loop through the vertices list
        for(int i = 0; i < vertices.count(); i++)
        {
            DSAGraphVertex currentVertex = vertices.get(i);

            // For each vertex, we loop through its adjacency list and remove any vertex with
            // the same label as the label of 'vertexToRemove'
            for(int j = 0; j < currentVertex.getAdjacent().count(); j++)
            {
                if(currentVertex.getAdjacent().get(j).getLabel() == vertexToRemove.getLabel())
                {
                    removeEdge(currentVertex.getLabel(), vertexToRemove.getLabel());
                }
            }
        }

        // We finally remove the vertex after removing edges connected to it
        vertices.remove(vertexToRemove);

        vertexCount--;
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
    // Mutator
    public void removeEdge(int label1, int label2)
    {
        DSAGraphVertex vertex1 = vertices.findVertex(label1);
        DSAGraphVertex vertex2 = vertices.findVertex(label2);

        // Remove 2 vertices in both directions as it is an undirected graph.
        vertex1.removeEdge(vertex2);
        vertex2.removeEdge(vertex1);

        edgeCount--;
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
        return vertexCount;
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

    // Accessor
    public void displayAsList()
    {
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Adjacency List:");

        for(int i = 0; i < vertices.count(); i++)
        {
            DSAGraphVertex currentVertex = vertices.get(i);

            // Print each vertex in the vertices list.
            System.out.print(currentVertex.getLabel() + " -> ");

            // For every vertex in the list, we print the adjacent vertices in the links list.
            for(int j = 0; j < currentVertex.getAdjacent().count(); j++)
            {
                System.out.print(currentVertex.getAdjacent().get(j).getLabel());

                if(j < currentVertex.getAdjacent().count() - 1)
                {
                    System.out.print(", ");
                }
            }
            
            // Print a newline
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
