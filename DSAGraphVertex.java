public class DSAGraphVertex
{
    // Class fields
    private int label;
    private Shop value;
    private DSALinkedList linksList;
    private boolean visited;

    // Constructor
    public DSAGraphVertex(int inputLabel, Shop inputValue)
    {
        label = inputLabel;
        value = inputValue;
        linksList = new DSALinkedList();
        visited = false;
    }

    // Accessor
    public int getLabel()
    {
        return label;
    }
    // Mutator
    public void setLabel(int pLabel)
    {
        label = pLabel;
    }

    // Accessor
    public Shop getValue()
    {
        return value;
    }

    public DSALinkedList getAdjacent()
    {
        return linksList;
    }

    // Mutator
    public void addEdge(DSAGraphVertex vertex)
    {
        linksList.insertLast(vertex);
        linksList.bubbleSort();
    }
    // Mutator
    public void removeEdge(DSAGraphVertex vertex)
    {
        linksList.remove(vertex);
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
}