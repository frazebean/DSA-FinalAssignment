public class GraphStack
{
    // Class fields
    private GraphLinkedList stack;

    // Default constructor
    public GraphStack()
    {
        stack = new GraphLinkedList();
    }

    // Accessor 'isEmpty'
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    // Mutator 'push'
    public void push(DSAGraphVertex value)
    {
        stack.insertFirst(value);
    }

    // Mutator 'pop'
    public DSAGraphVertex pop()
    {
        DSAGraphVertex popValue;
        if(isEmpty())
        {
            System.out.println("No value to pop from top of stack. (Stack is empty).");
            popValue = null;

        }
        else
        {
            popValue = stack.removeFirst();
        }
        return popValue;
    }
    // Accessor 'top'
    public DSAGraphVertex top()
    {
        DSAGraphVertex topValue;
        if(isEmpty())
        {
            System.out.println("No value on the top of stack. (Stack is empty).");
            topValue = null;
        }
        else
        {
            topValue = stack.peekFirst();
        }
        return topValue;
    }
}