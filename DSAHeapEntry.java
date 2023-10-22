public class DSAHeapEntry 
{
    // Class fields
    private int priority;
    private Shop value;

    // Default constructor
    public DSAHeapEntry()
    {
        priority = 0;
        value = null;
    }

    // Accessor
    public int getPriority()
    {
        return priority;
    }
    // Mutator
    public void setPriority(int pPriority)
    {
        priority = pPriority;
    }

    // Accessor
    public Shop getValue()
    {
        return value;
    }
    // Mutator
    public void setValue(Shop pValue)
    {
        value = pValue;
    }
}