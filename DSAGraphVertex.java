public class DSAGraphVertex
{
    // Class fields
    private int label;
    private Object value;
    private DSALinkedList linksList;
    private boolean visited;

    // Constructor
    public DSAGraphVertex(int inputLabel, Object inputValue)
    {
        label = inputLabel;
        value = inputValue;
        visited = false;
    }

    // Accessor
    public int getLabel()
    {
        return label;
    }
    // Accessor
    public Object getValue()
    {
        return value;
    }

    // Ignore getAdjacent() for now

    // Mutator
    public void addEdge(DSAGraphVertex vertex)
    {
        linksList.insertLast(vertex);
    }

    // Mutator
    public void setVisited()
    {
        visited = true;
    }
    // Mutator
    public void clearVisited()
    {
        visited = false;
    }
    // Accessor
    public boolean getVisited()
    {
        return visited;
    }

    // Ignore toString() for now
}