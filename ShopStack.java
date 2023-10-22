public class ShopStack
{
    // Class fields
    private HashTableLinkedList stack;

    // Default constructor
    public ShopStack()
    {
        stack = new HashTableLinkedList();
    }

    // Accessor 'isEmpty'
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    // Mutator 'push'
    public void push(Shop value)
    {
        stack.insertFirst(value);
    }

    // Mutator 'pop'
    public Shop pop()
    {
        Shop popValue;
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
    public Shop top()
    {
        Shop topValue;
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